package com.ai5suoai.file.exception;

import com.ai5suoai.commons.Code;

import java.io.IOException;

/**
 * 上传文件的异常类
 *
 * @author chenzhenjia
 * @since 16/7/1
 */
public class FileUploadException extends IOException implements Code<Integer, String> {
    private Code<Integer, String> code;

    public FileUploadException(Code<Integer, String> code) {
        super(code.msg());
        this.code = code;
    }

    public FileUploadException(Code<Integer, String> code, Throwable cause) {
        super(code.msg(), cause);
        this.code = code;
    }

    @Override
    public Integer code() {
        return code.code();
    }

    @Override
    public String msg() {
        return code.msg();
    }
}
