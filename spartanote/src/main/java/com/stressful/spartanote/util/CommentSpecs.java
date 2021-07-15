package com.stressful.spartanote.util;

import com.stressful.spartanote.domain.Comment;
import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

    public static Specification<Comment> withAritcle_id(Long aritcle_id) {
        return ((root, query, builder) ->
                builder.equal(root.get("article_id"), aritcle_id)
        );
    }

}
