package com.project.booktalking.web.dto;

import lombok.Builder;

import java.util.List;

public class BookRespListDto {

    List<BookRespDto> bookList;

    @Builder
    public BookRespListDto(List<BookRespDto> bookList) {
        this.bookList = bookList;
    }
}