package com.social.chenl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author lance.chen
 * 自定义错误信息
 * Spring-boot 2.0重构
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Value("${server.servlet.context-path}")
    private String servletPath;


    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, servletPath + "400");
        ErrorPage error401Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, servletPath + "500");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, servletPath + "404");
        registry.addErrorPages(error400Page, error401Page, error404Page);
    }


}
