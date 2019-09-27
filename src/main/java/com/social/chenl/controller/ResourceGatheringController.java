package com.social.chenl.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.social.chenl.service.ResourceGatheringService;
import com.social.chenl.vo.IncVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : lance.chen
 *
 * time   : 2019/04/20
 * desc   : 资源采集
 * version: 1.0
 */
@Api(tags = "08-inc", value = "ResourceGatheringApi", description = "资源采集接口")
@RestController
@RequestMapping("/inc")
public class ResourceGatheringController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ResourceGatheringService resourceGatheringService;

    @ApiOperation(value = "采集接口", notes = "资源采集接口-直接转json")
    @RequestMapping(value = "/direct/api", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject directApi(IncVO incVO) {
        return resourceGatheringService.directApi(incVO);
    }

    @ApiOperation(value = "采集接口", notes = "资源采集接口-解析后转json")
    @RequestMapping(value = "/parse/api", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject parseApi(IncVO incVO) {
        return resourceGatheringService.parseApi(incVO);
    }
}
