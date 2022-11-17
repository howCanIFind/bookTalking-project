package com.project.booktalking.web.dto;

import com.project.booktalking.domain.book.Book;
import lombok.Getter;

@Getter
public class BookReqDto {

    private String name;

    private String author;

    private String summary;

    private String companyName;

    public Book toBook() {
        return Book.builder()
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();
    }
}
