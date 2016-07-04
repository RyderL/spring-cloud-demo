package com.ai5suoai.cloud.v1.user;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
public interface User {
    /**
     * 用户名
     */
    String getUsername();

    /**
     * 昵称
     */
    String getNickname();

    /**
     * 角色
     */
    Role getRole();

}
