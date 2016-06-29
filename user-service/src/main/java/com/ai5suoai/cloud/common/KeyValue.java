package com.ai5suoai.cloud.common;

import java.util.Map;

/**
 * @author chenzhenjia
 * @since 16/6/22
 */
public interface KeyValue<K, V> extends Map.Entry<K, V> {
    /**
     * 获取描述文本
     *
     * @return 文本
     */
    String getText();

}
