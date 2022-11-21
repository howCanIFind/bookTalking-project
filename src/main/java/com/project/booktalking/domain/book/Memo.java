package com.project.booktalking.domain.book;

import com.project.booktalking.web.dto.MemoRespDto;
import lombok.Builder;

import javax.persistence.*;

@Entity
public class Memo {

    @Id @GeneratedValue
    private String id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @Builder
    public Memo(String content, Book book) {
        this.content = content;
        this.book = book;
    }


    protected Memo() {

    }

    public MemoRespDto toRespDto() {
        return MemoRespDto.builder()
                .content(content)
                .build();
    }
}
