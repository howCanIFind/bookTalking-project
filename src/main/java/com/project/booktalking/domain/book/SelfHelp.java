package com.project.booktalking.domain.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SelfHelp extends Book{

    private String content;

    public SelfHelp(Long id, String name, String author, String summary, String content) {
        super(id, name, author, summary);
        this.content = content;
    }

    protected SelfHelp() {

    }
}
