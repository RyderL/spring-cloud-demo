package com.ai5suoai.oauth.test;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
public class Test extends ResourceSupport {

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
