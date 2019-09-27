package com.social.chenl.service;

import com.social.chenl.result.Result;
import com.social.chenl.vo.FeedActionVO;

/**
 * @author : lance.chen
 *
 * time   : 2018/02/05
 * desc   : 动态相关操作，0点赞1收藏
 * version: 1.0
 */
public interface FeedActionService {

    Result saveFeedAction(FeedActionVO feedActionVO, String userId);

    Result removeFeedAction(FeedActionVO feedActionVO, String userId);
}
