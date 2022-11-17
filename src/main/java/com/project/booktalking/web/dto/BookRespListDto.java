package com.project.booktalking.web.dto;

import lombok.Builder;

import java.util.List;

public class BookRespListDto {

    List<BookRespDto> bookRespDtoList;

    @Builder
    public BookRespListDto(List<BookRespDto> bookRespDtoList) {
        this.bookRespDtoList = bookRespDtoList;
    }
}