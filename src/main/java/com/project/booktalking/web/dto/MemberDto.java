package com.project.booktalking.web.dto;

import lombok.Getter;

@Getter
public class MemberDto {

    private String memberEmail;

    private String memberPassword;


    public MemberDto(String memberEmail, String memberPassword) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
    }
}
