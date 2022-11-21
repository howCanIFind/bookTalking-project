package com.project.booktalking.web.dto;

import lombok.Builder;

public class MemoRespDto {

    private String content;

    @Builder
    public MemoRespDto(String content) {
        this.content = content;
    }
}
