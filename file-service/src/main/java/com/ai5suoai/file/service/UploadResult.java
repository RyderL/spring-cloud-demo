package com.ai5suoai.file.service;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

/**
 * @author chenzhenjia
 * @since 16/6/30
 */
public class UploadResult extends ResourceSupport implements Serializable, Cloneable {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
