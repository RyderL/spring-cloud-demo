package com.ai5suoai.file.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * 上传文件接口,期望所有的上传文件的接口都实现该类
 *
 * @author chenzhenjia
 * @since 16/7/1
 */
public interface FileUploadService {

    /**
     * 上传方法
     *
     * @param fileName 文件的绝对路径
     * @param is       输入流
     * @return 文件的上传结果
     * @throws IOException 上传时抛出的异常
     */
    UploadResult upload(String fileName, InputStream is) throws IOException;
}
