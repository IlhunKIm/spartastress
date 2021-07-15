package com.stressful.spartanote.controller;


import com.stressful.spartanote.dto.SignupRequestDto;
import com.stressful.spartanote.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/error")
    public String loginerror(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("user/signup")
    public String signup(){
        return "signup";
    }
//     회원 가입 요청 처리 & 중복및 오류체크
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto signupRequestDto, Model model) {
        try {
            userService.registerUser(signupRequestDto);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException);
            model.addAttribute("message", illegalArgumentException.getMessage());
        }
        return "redirect:/user/login";
    }
//     카카오 관련
    @GetMapping("user/kakao/callback")
    public String kakaoLogin(String code) {
        userService.kakaoLogin(code);

        return "redirect:/";
    }


}
