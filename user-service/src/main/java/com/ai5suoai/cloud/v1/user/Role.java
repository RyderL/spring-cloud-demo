package com.ai5suoai.cloud.v1.user;

import com.ai5suoai.cloud.common.KeyValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
@Document
public class Role implements KeyValue<String, String> {
    @Id
    private String id;
    private String value;
    private String text;

    @Override
    public String getKey() {
        return id;
    }

    public void setKey(String key) {
        this.id = key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String setValue(String value) {
        return this.value = value;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
