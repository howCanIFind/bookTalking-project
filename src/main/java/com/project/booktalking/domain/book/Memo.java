package com.project.booktalking.domain.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Memo {

    @Id @GeneratedValue
    private String id;

    private String content;
}
