package com.project.booktalking.web.dto;

import lombok.Builder;

import java.util.List;

public class MemoListRespDto {

    List<MemoRespDto> memoList;

    @Builder
    public MemoListRespDto(List<MemoRespDto> memoList) {
        this.memoList = memoList;
    }
}
