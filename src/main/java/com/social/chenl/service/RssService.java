package com.social.chenl.service;

import com.social.chenl.result.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : lance.chen
 *
 * time   : 2018/05/16
 * desc   : 资源服务相关
 * version: 1.0
 */
public interface RssService {

    Result uploadUserImage(MultipartFile[] files);

    Result uploadFeedImage(MultipartFile[] files);
}
