package com.ai5suoai.file.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 文件业务类
 *
 * @author chenzhenjia
 * @since 16/6/30
 */
@Service
public class FileService {
    private final MessageDigest md5;
    private static final Logger log = LoggerFactory.getLogger(FileService.class);
    @Autowired
    @Qualifier("qiNiuFileUploadService")
    private FileUploadService fileUploadService;

    public FileUploadService getFileUploadService() {
        return fileUploadService;
    }

    public void setFileUploadService(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    public UploadResult upload(String dir, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        log.info("上传文件文件夹名:{},文件大小为:{},远程文件名为:{},", dir, file.getSize(), originalFilename);
        String suffix = "";
        if (originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String fileKey = dir + "/" + getMD5ByByte(file.getBytes()) + suffix;
        log.info("上传文件上传的文件key为:{}", fileKey);
        UploadResult upload = fileUploadService.upload(fileKey, file.getInputStream());
        log.info("上传文件成功,文件地址为:{}", upload.getUrl());
        return upload;
    }

    public FileService() throws Exception {
        md5 = MessageDigest.getInstance("MD5");
    }

    /**
     * 获取字节数组的md5值
     *
     * @param bytes 字节数组
     * @return 返回md5值
     */
    public String getMD5ByByte(byte[] bytes) {
        byte[] digest = md5.digest(bytes);
        String s = new BigInteger(1, digest).toString(16);
        log.info("校验后的md5为:{}", s);
        return s;
    }
}
