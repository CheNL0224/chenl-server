package com.social.chenl.controller;

import com.social.chenl.result.Result;
import com.social.chenl.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lance.chen
 * desc   : app版本
 * version: 1.0
 */
@Api(tags = "06-app-version", value = "AppApi", description = "Android App版本接口")
@RestController
@RequestMapping("/app/version")
public class AppVersionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AppVersionService appVersionService;

    @ApiOperation(value = "最新app版本", notes = "获取最新app版本接口")
    @RequestMapping(value = "/latest", method = RequestMethod.POST)
    @ResponseBody
    public Result latestVersion() {
        return appVersionService.latestVersion();
    }

}
