package com.stressful.spartanote.service;


import com.stressful.spartanote.domain.Comment;
import com.stressful.spartanote.dto.CommentRequestDto;
import com.stressful.spartanote.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public Long update_comment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID not found")
        );
        comment.update_comment(commentRequestDto);
        return comment.getId();
    }

}
