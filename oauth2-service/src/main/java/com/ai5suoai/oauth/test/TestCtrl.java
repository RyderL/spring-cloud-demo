package com.ai5suoai.oauth.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
@RestController
@RequestMapping("/v1")
public class TestCtrl {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<Test> ping(HttpServletRequest request) {
        Test test = new Test();
        test.setIp(request.getRemoteAddr());
        test.add(linkTo(methodOn(TestCtrl.class).ping(request)).withSelfRel());
        return ResponseEntity.ok(test);
    }

}
