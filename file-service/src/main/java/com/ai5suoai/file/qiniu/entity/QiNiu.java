package com.ai5suoai.file.qiniu.entity;

import com.ai5suoai.file.qiniu.QiNiuProperties;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.Serializable;

/**
 * 专门针对七牛的实体类
 *
 * @author chenzhenjia
 * @since 16/6/29
 */
public class QiNiu implements Serializable {

    private Auth auth;
    private UploadManager uploadManager;
    private String defaultToken;
    private QiNiuProperties.Bucket defaultBucket;

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public String getDefaultToken() {
        return defaultToken;
    }

    public void setDefaultToken(String defaultToken) {
        this.defaultToken = defaultToken;
    }

    public UploadManager getUploadManager() {
        return uploadManager;
    }

    public void setUploadManager(UploadManager uploadManager) {
        this.uploadManager = uploadManager;
    }

    public String getUpToken(String bucketName) {
        return auth.uploadToken(bucketName);
    }

    public QiNiuProperties.Bucket getDefaultBucket() {
        return defaultBucket;
    }

    public void setDefaultBucket(QiNiuProperties.Bucket defaultBucket) {
        this.defaultBucket = defaultBucket;
    }

    public String getBucketUrl() {
        return defaultBucket.getUrl();
    }

    public String getBucketName() {
        return defaultBucket.getName();
    }

    public String getResourceUrl(String fileKey) {
        return getBucketUrl() + "/" + fileKey;
    }
}
