package com.social.chenl.config;

import com.social.chenl.constant.RssConfig;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import java.io.File;

/**
 * @author lance.chen
 * 解决The temporary upload location is not valid
 */
@Configuration
public class MultipartConfiguration {

    @Resource
    private RssConfig rssConfig;

    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = rssConfig.getUploadPath() + "/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }
}
