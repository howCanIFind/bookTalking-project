package com.project.booktalking.web.dto;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;
import lombok.Getter;

@Getter
public class MemoReqDto {

    private String content;

    public MemoReqDto(String content) {
        this.content = content;
    }

    public Memo toEntity(Book book) {
        return Memo.builder()
                .content(content)
                .book(book)
                .build();
    }


}
