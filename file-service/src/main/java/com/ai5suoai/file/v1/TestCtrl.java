package com.ai5suoai.file.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author chenzhenjia
 * @since 16/6/30
 */
@RestController
@RequestMapping("/v1/test")
public class TestCtrl {
    private static final Logger log = LoggerFactory.getLogger(TestCtrl.class);

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<?> ping(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("remoteIp", request.getRemoteAddr());
        result.put("localIp", request.getLocalAddr());
        log.info("ping 测试,result:{}", request);
        Resource<Map<String, Object>> resource = new Resource<>(result);
        resource.add(linkTo(TestCtrl.class).withSelfRel());
        return ResponseEntity.ok(resource);
    }


}
