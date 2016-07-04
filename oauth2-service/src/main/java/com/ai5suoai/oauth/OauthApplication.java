package com.ai5suoai.oauth;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
@SpringBootApplication
@EnableSidecar
public class OauthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OauthApplication.class)
                .bannerMode(Banner.Mode.OFF).run(args);
    }
}
