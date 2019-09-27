package com.social.chenl.dao;

import com.social.chenl.model.Comment;
import com.social.chenl.vo.FeedCommentVO;

import java.util.List;

/**
 * @author : lance.chen
 *
 * time   : 2018/02/05
 * desc   : 动态评论
 * version: 1.0
 */
public interface FeedCommentDao {

    Integer commentTotal();

    List<Comment> pageFeedComment(FeedCommentVO feedCommentVO);
}
