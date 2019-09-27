package com.social.chenl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lance.chen
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan(basePackages = {"com.social.chenl.mapper", "com.social.chenl.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication ap = new SpringApplication(Application.class);
        ap.setBannerMode(Banner.Mode.OFF);
        ap.run(args);
    }
}
