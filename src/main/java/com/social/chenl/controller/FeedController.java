package com.social.chenl.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.social.chenl.result.Result;
import com.social.chenl.service.FeedService;
import com.social.chenl.util.ParamUtil;
import com.social.chenl.vo.FeedSaveVO;
import com.social.chenl.vo.FeedSearchVO;
import com.social.chenl.vo.IdVO;
import com.social.chenl.vo.RelevantVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author lance.chen
 * 动态相关
 */
@Api(tags = "02-feed", value = "FeedApi", description = "动态相关接口")
@RestController
@RequestMapping("/feed")
public class FeedController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FeedService feedService;

    /**
     * 动态分页
     */
    @ApiOperation(value = "分页动态", notes = "分页动态接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "X-App-Token", value = "token", required = true),
            @ApiImplicitParam(paramType="form", name = "pageNum", value = "页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType="form", name = "pageSize", value = "页容量", required = true, defaultValue = "10"),
            @ApiImplicitParam(paramType="form", name = "searchUserId", value = "查询用户id")
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public Result pageFeed(@ApiIgnore FeedSearchVO feedSearchVO,
                           @ApiIgnore @RequestAttribute(name = "userId") String userId) {

        if (feedSearchVO == null) {
            return Result.paramIsNull();
        }

        if (ParamUtil.pageIsNull(feedSearchVO)) {
            return Result.pageIsNull();
        }

        logger.info("param is :" + feedSearchVO.toString());

        return feedService.pageFeed(feedSearchVO, userId);
    }

    /**
     * 动态保存
     */
    @ApiOperation(value = "发布动态", notes = "发布动态接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "X-App-Token", value = "token", required = true),
            @ApiImplicitParam(paramType="form", name = "feedInfo", value = "动态内容", required = true),
            @ApiImplicitParam(paramType="query", name = "photoList", value = "图片列表 - 测试建议忽略")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result saveFeed(@ApiIgnore FeedSaveVO feedSaveVO,
                           @ApiIgnore @RequestAttribute(name = "userId") String userId) {

        if (feedSaveVO == null) {
            return Result.paramIsNull();
        }

        logger.info("param is :" + feedSaveVO.toString());

        return feedService.saveFeed(feedSaveVO, userId);
    }

    /**
     * 动态查看
     */
    @ApiOperation(value = "动态查看数+1", notes = "动态查看数+1接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "X-App-Token", value = "token", required = true),
            @ApiImplicitParam(paramType="form", name = "id", value = "动态id", required = true)
    })
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public Result viewFeed(IdVO idVO) {

        if (idVO == null) {
            return Result.paramIsNull();
        }

        if (StringUtils.isEmpty(idVO.getId())) {
            return Result.idIsNull();
        }

        logger.info("param is :" + idVO.toString());

        return feedService.viewFeed(idVO);
    }

    /**
     * 与我相关
     */
    @ApiOperation(value = "与我相关", notes = "与我相关接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "X-App-Token", value = "token", required = true),
            @ApiImplicitParam(paramType="form", name = "pageNum", value = "页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType="form", name = "pageSize", value = "页容量", required = true, defaultValue = "10")
    })
    @RequestMapping(value = "/relevant", method = RequestMethod.POST)
    @ResponseBody
    public Result pageRelevant(@ApiIgnore RelevantVO relevantVO,
                               @ApiIgnore @RequestAttribute(name = "userId") String userId) {

        if (relevantVO == null) {
            return Result.paramIsNull();
        }

        if (ParamUtil.pageIsNull(relevantVO)) {
            return Result.pageIsNull();
        }

        logger.info("param is :" + relevantVO.toString());

        return feedService.pageRelevant(relevantVO, userId);
    }

    /**
     * 我的回复
     */
    @ApiOperation(value = "我的回复", notes = "我的回复接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header", name = "X-App-Token", value = "token", required = true),
            @ApiImplicitParam(paramType="form", name = "pageNum", value = "页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType="form", name = "pageSize", value = "页容量", required = true, defaultValue = "10")
    })
    @RequestMapping(value = "/mine/reply", method = RequestMethod.POST)
    @ResponseBody
    public Result pageMineReply(@ApiIgnore RelevantVO relevantVO,
                                @ApiIgnore @RequestAttribute(name = "userId") String userId) {

        if (relevantVO == null) {
            return Result.paramIsNull();
        }

        if (ParamUtil.pageIsNull(relevantVO)) {
            return Result.pageIsNull();
        }

        logger.info("param is :" + relevantVO.toString());

        return feedService.pageMineReply(relevantVO, userId);
    }
}