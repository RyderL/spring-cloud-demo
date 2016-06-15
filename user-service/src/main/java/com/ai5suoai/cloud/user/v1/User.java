package com.ai5suoai.cloud.user.v1;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author chenzhenjia
 * @since 16/5/23
 */
@Entity
public class User {
    @Id
    private Long id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "authorities=" + authorities +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
