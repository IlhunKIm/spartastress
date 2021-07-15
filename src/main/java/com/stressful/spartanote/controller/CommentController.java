package com.stressful.spartanote.controller;

import com.stressful.spartanote.domain.Comment;
import com.stressful.spartanote.dto.CommentRequestDto;
import com.stressful.spartanote.repository.CommentRepository;
import com.stressful.spartanote.service.CommentService;
import com.stressful.spartanote.util.CommentSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("/api/comment/{article_id}")
    public List<Comment> getComment(@PathVariable Long article_id) {
        return commentRepository.findAll(CommentSpecs.withAritcle_id(article_id));
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.update_comment(id, commentRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }






}
