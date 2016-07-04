package com.ai5suoai.commons;

import static com.ai5suoai.commons.HttpCodes.BAD_REQUEST;
import static com.ai5suoai.commons.HttpCodes.NOT_FOUND;
import static com.ai5suoai.commons.HttpCodes.SERVER_ERROR;

/**
 * @author chenzhenjia
 * @since 16/7/2
 */
public class RestError {
    private long timestamp;
    private int status;
    private String error;
    private String message;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static ErrorBuilder badRequest() {
        return status(BAD_REQUEST);
    }

    public static ErrorBuilder notFound() {
        return status(NOT_FOUND);
    }

    public static ErrorBuilder serverError() {
        return status(SERVER_ERROR);
    }

    public static ErrorBuilder status(HttpCodes code) {
        return new ErrorBuilder(code);
    }

    public static class ErrorBuilder {
        private HttpCodes httpCode;

        public ErrorBuilder(HttpCodes httpCode) {
            this.httpCode = httpCode;
        }

        public RestError message(String msg) {
            RestError result = new RestError();
            result.setError(httpCode.getReason());
            result.setStatus(httpCode.getValue());
            result.setTimestamp(System.currentTimeMillis());
            result.setMessage(msg);
            return result;
        }
    }

}
