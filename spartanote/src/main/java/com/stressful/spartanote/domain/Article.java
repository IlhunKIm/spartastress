package com.stressful.spartanote.domain;

import com.stressful.spartanote.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Article extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Article(ArticleRequestDto articleRequestDto) {
        this.username = articleRequestDto.getUsername();
        this.title = articleRequestDto.getTitle();
        this.contents = articleRequestDto.getContents();

    }

    public void update(ArticleRequestDto articleRequestDto) {
        this.username = articleRequestDto.getUsername();
        this.title = articleRequestDto.getTitle();
        this.contents = articleRequestDto.getContents();
    }


}
