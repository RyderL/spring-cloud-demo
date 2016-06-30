package com.ai5suoai.file.qiniu;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author chenzhenjia
 * @since 16/6/30
 */
public class UploadResult extends ResourceSupport {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
