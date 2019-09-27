package com.social.chenl.service;

import com.social.chenl.result.Result;
import com.social.chenl.vo.FeedCommentSaveVO;
import com.social.chenl.vo.FeedCommentVO;

/**
 * @author : lance.chen
 *
 * time   : 2018/02/05
 * desc   : 动态评论
 * version: 1.0
 */
public interface FeedCommentService {

    Result pageFeedComment(FeedCommentVO feedCommentVO);

    Result saveFeedComment(FeedCommentSaveVO feedCommentSaveVO, String userId);

    Result unreadReply(String userId);

    Result updateUnreadReply(String userId);
}
