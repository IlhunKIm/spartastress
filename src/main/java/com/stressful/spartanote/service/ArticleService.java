package com.stressful.spartanote.service;

import com.stressful.spartanote.domain.Article;
import com.stressful.spartanote.dto.ArticleRequestDto;
import com.stressful.spartanote.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long update(Long id, ArticleRequestDto articleRequestDto) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID not found")
        );
        article.update(articleRequestDto);
        return article.getId();
    }


}
