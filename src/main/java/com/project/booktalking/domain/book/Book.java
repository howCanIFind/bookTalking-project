package com.project.booktalking.domain.book;

import com.project.booktalking.web.dto.BookReqDto;
import com.project.booktalking.web.dto.BookRespDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Book {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String author;

    private String summary;

    private String companyName;


    protected Book() {

    }

    @Builder
    public Book(String name, String author, String summary, String companyName) {
        this.name = name;
        this.author = author;
        this.summary = summary;
        this.companyName = companyName;
    }

    public void update(BookReqDto bookReqDto) {
        this.name = bookReqDto.getName();
        this.author = bookReqDto.getAuthor();
        this.summary = bookReqDto.getSummary();
        this.companyName = bookReqDto.getCompanyName();
    }

    public BookRespDto toDto() {
        return BookRespDto.builder()
                .id(id)
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();
    }
}

