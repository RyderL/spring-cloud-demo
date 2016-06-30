package com.ai5suoai.file.qiniu;

import com.ai5suoai.file.qiniu.entity.QiNiu;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 七牛的配置类
 *
 * @author chenzhenjia
 * @since 16/6/29
 */
@Configuration
@Import(QiNiuProperties.class)
public class QiNiuConfiguration {
    @Autowired
    QiNiuProperties qiNiuProperties;

    @Bean
    public QiNiu qiNiu() {
        QiNiu qiNiu = new QiNiu();
        Auth auth = Auth.create(qiNiuProperties.getAccessKey(), qiNiuProperties.getSecretKey());
        qiNiu.setAuth(auth);
        qiNiu.setDefaultToken(auth.uploadToken(qiNiuProperties.getDefaultBucket().getName()));
        qiNiu.setUploadManager(new UploadManager());
        qiNiu.setDefaultBucket(qiNiuProperties.getDefaultBucket());
        return qiNiu;
    }
}
