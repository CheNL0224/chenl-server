package com.social.chenl.service.impl;

import com.social.chenl.entity.TAppVersion;
import com.social.chenl.mapper.TAppVersionMapper;
import com.social.chenl.result.Result;
import com.social.chenl.service.AppVersionService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lance.chen
 *
 *
 * desc   : app版本
 * version: 1.0
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private TAppVersionMapper tAppVersionMapper;

    @Override
    public Result latestVersion() {

        Example example = new Example(TAppVersion.class);
        example.setOrderByClause("version_code desc");

        List<TAppVersion> tAppVersions = tAppVersionMapper.selectByExample(example);
        TAppVersion tAppVersion = null;
        if (tAppVersions != null && tAppVersions.size() > 0) {
            tAppVersion = tAppVersions.get(0);
        }

        return Result.success(tAppVersion);
    }
}
