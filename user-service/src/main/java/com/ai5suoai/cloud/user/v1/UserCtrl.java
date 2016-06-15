package com.ai5suoai.cloud.user.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author chenzhenjia
 * @since 16/6/15
 */
@RestController
@RequestMapping("/v1/users")
public class UserCtrl {
    private static final Logger log = LoggerFactory.getLogger(UserCtrl.class);

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity ping(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        log.info("remoteAddr : {}, remoteHost : {}", remoteAddr, remoteHost);
        return new ResponseEntity(OK);
    }

}
