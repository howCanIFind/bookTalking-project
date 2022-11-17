package com.project.booktalking.web.dto;

import lombok.Builder;

public class BookRespDto {

    private Long id;

    private String name;

    private String author;

    private String summary;

    private String companyName;

    @Builder
    public BookRespDto(Long id, String name, String author, String summary, String companyName) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.summary = summary;
        this.companyName = companyName;
    }
}
