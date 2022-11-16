package com.project.booktalking.domain.book;

import com.project.booktalking.domain.book.Book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
public class Novel extends Book {

    private String content;

    public Novel(Long id, String name, String author, String summary, String content) {
        super(id, name, author, summary);
        this.content = content;
    }

    protected Novel() {

    }
}
