package com.project.booktalking.domain.book;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public abstract class Book {

    @Id @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String author;

    private String summary;


    @Builder
    public Book(Long id, String name, String author, String summary) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.summary = summary;
    }

    public Book() {

    }
}

