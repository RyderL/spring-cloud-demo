package com.ai5suoai.file.qiniu;

import com.ai5suoai.commons.impl.BaseCode;
import com.ai5suoai.file.exception.FileUploadException;
import com.ai5suoai.file.qiniu.entity.QiNiu;
import com.ai5suoai.file.service.UploadResult;
import com.ai5suoai.file.service.FileUploadService;
import com.qiniu.http.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 七牛的文件上传实现类
 *
 * @author chenzhenjia
 * @since 16/7/1
 */
@Component
public class QiNiuFileUploadService implements FileUploadService {
    @Autowired
    QiNiu qiNiu;
    private static final Logger log = LoggerFactory.getLogger(QiNiuFileUploadService.class);

    @Override
    public UploadResult upload(String fileName, InputStream is) throws IOException {
        byte[] bytes = FileCopyUtils.copyToByteArray(is);
        Response response = qiNiu.getUploadManager().put(bytes, fileName, qiNiu.getDefaultToken());
        log.info("七牛文件上传,上传的结果为:{}", response.bodyString());
        if (!response.isOK()) {
            throw new FileUploadException(new BaseCode<>(1, "上传失败"));
        }
        return new UploadResult() {{
            setUrl(qiNiu.getResourceUrl(fileName));
        }};
    }
}
