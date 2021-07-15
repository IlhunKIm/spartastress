package com.stressful.spartanote.controller;

import com.stressful.spartanote.domain.Article;
import com.stressful.spartanote.dto.ArticleRequestDto;
import com.stressful.spartanote.repository.ArticleRepository;
import com.stressful.spartanote.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @PostMapping("/api/articles/")
    public Article createArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        Article article = new Article(articleRequestDto);
        return articleRepository.save(article);
    }

    @GetMapping("/api/articles/")
    public List<Article> getArticle() {
        return articleRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/detail/{id}")
    public Article getDetail(@PathVariable Long id) {
        return articleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null")
        );
    }

    @PutMapping("/api/articles/{id}")
    public Long updateArticle(@PathVariable Long id, @RequestBody ArticleRequestDto articleRequestDto) {
        return articleService.update(id, articleRequestDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public Long deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return id;
    }

}
