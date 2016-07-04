package com.ai5suoai.commons.impl;

import com.ai5suoai.commons.Code;

/**
 * @author chenzhenjia
 * @since 16/7/1
 */
public class BaseCode<C, M> implements Code<C, M> {
    private C code;
    private M msg;

    public BaseCode(C code, M msg) {
        this.code = code;
        this.msg = msg;
    }

    public C code() {
        return code;
    }

    public M msg() {
        return msg;
    }
}
