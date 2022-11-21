package com.project.booktalking.web.dto;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;

public class MemoReqDto {

    private String content;

    public Memo toEntity(Book book) {
        return Memo.builder()
                .content(content)
                .book(book)
                .build();
    }
}
