package com.lls.springboot.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Spring Security中存放的认证用户
 * @author Niu Li
 * @since 2017/6/28
 */
public class UserAuthentication implements Authentication {

    private static final long serialVersionUID = 3730332217518791533L;

    private User user;

    private Boolean authentication = false;

    public UserAuthentication(User user, Boolean authentication) {
        this.user = user;
        this.authentication = authentication;
    }
    //这里的权限是FilterSecurityInterceptor做权限验证使用
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(user.getRoles().split(",")).collect(Collectors.toList()).stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authentication = isAuthenticated;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
