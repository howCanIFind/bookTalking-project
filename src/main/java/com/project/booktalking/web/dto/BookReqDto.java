package com.project.booktalking.web.dto;

import com.project.booktalking.domain.book.Book;
import lombok.Getter;

@Getter
public class BookReqDto {

    private String name;

    private String author;

    private String summary;

    private String companyName;

    public BookReqDto(String name, String author, String summary, String companyName) {
        this.name = name;
        this.author = author;
        this.summary = summary;
        this.companyName = companyName;
    }

    public Book toBook() {
        return Book.builder()
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();
    }
}
