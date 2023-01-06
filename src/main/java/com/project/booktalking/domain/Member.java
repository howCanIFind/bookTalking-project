package com.project.booktalking.domain;

import com.project.booktalking.web.dto.MemberDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    private String role; //ROLE_USER, ROLE_ADMIN

    private String provider;

    private String providerId;


}
