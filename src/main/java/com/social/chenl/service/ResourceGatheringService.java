package com.social.chenl.service;

import com.alibaba.fastjson.JSONObject;
import com.social.chenl.vo.IncVO;

/**
 * @author : lance.chen
 * e-mail  : bafs.jy@live.com
 * time    : 2019/04/20
 * desc    : 资源采集
 * version : 1.0
 */
public interface ResourceGatheringService {

    JSONObject directApi(IncVO incVO);

    JSONObject parseApi(IncVO incVO);
}
