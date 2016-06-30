package com.ai5suoai.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
