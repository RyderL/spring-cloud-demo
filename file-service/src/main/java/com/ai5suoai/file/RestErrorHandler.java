package com.ai5suoai.file;

import com.ai5suoai.commons.RestError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

/**
 * @author chenzhenjia
 * @since 16/6/30
 */
@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public ResponseEntity handleMultipartException(MultipartException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestError.serverError().message(ex.getMessage()));
    }

}
