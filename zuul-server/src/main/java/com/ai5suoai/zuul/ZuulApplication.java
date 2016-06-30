package com.ai5suoai.zuul;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args)
        ;
    }

}
