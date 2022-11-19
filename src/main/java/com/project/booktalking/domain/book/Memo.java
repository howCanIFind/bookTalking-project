package com.project.booktalking.domain.book;

import javax.persistence.*;

@Entity
public class Memo {

    @Id @GeneratedValue
    private String id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
