package com.ai5suoai.file.qiniu;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 七牛的属性类
 *
 * @author chenzhenjia
 * @since 16/6/29
 */
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {
    private String accessKey;
    private String secretKey;
    private Bucket defaultBucket;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Bucket getDefaultBucket() {
        return defaultBucket;
    }

    public void setDefaultBucket(Bucket defaultBucket) {
        this.defaultBucket = defaultBucket;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public static class Bucket {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
