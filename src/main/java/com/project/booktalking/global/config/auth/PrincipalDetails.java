package com.project.booktalking.global.config.auth;

import com.project.booktalking.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PrincipalDetails implements UserDetails {

    private static final long serialVersionID = 1L;
    private Member member;
    private Map<String, Object> attributes;

    // 일반 시큐어리티 로그인시 사용
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
        collect.add(() -> {return member.getRole();});
        return collect;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    // 리소스 서버로부터 받는 회원정보
//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    // member 의 PrimaryKey
//    @Override
//    public String getName() {
//        return member.getId()+"";
//    }
}
