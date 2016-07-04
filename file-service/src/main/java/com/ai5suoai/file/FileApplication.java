package com.ai5suoai.file;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenzhenjia
 * @since 16/6/29
 */
@SpringBootApplication
@EnableEurekaClient
public class FileApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FileApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args)
        ;
    }
}
