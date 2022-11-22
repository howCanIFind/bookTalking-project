package com.project.booktalking.domain.book;

import com.project.booktalking.web.dto.MemoReqDto;
import com.project.booktalking.web.dto.MemoRespDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Memo {

    @Id @GeneratedValue
    private Long id;

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
                .memoId(id)
                .content(content)
                .build();
    }

    public void update(MemoReqDto memoReqDto) {
        this.content = memoReqDto.getContent();
    }
}
