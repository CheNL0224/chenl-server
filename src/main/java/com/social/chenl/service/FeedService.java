package com.social.chenl.service;

import com.social.chenl.result.Result;
import com.social.chenl.vo.FeedSaveVO;
import com.social.chenl.vo.FeedSearchVO;
import com.social.chenl.vo.IdVO;
import com.social.chenl.vo.RelevantVO;
import com.social.chenl.vo.*;

/**
 * @author : lance.chen
 *
 * time   : 2018/02/05
 * desc   : 动态
 * version: 1.0
 */
public interface FeedService {

    Result pageFeed(FeedSearchVO feedSearchVO, String userId);

    Result saveFeed(FeedSaveVO feedSaveVO, String userId);

    Result viewFeed(IdVO idVO);

    Result pageRelevant(RelevantVO relevantVO, String userId);

    Result pageMineReply(RelevantVO relevantVO, String userId);
}