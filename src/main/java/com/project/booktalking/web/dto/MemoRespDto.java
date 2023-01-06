package com.project.booktalking.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemoRespDto {

    private Long memoId;

    private String content;

    @Builder
    public MemoRespDto(Long memoId, String content) {
        this.memoId = memoId;
        this.content = content;
    }
}
