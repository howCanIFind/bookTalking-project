package com.project.booktalking.domain.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Programming extends Book {

    private String content;

    private String code;

    protected Programming() {

    }

    public Programming(Long id, String name, String author, String summary, String content, String code) {
        super(id, name, author, summary);
        this.content = content;
        this.code = code;
    }
}
