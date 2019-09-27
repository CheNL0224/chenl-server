package com.social.chenl.dao;

import com.social.chenl.entity.TFeedAction;

import java.util.List;

/**
 * @author : lance.chen
 * desc   : 动态操作，包含点赞，收藏
 * version: 1.0
 */
public interface FeedActionDao {

    List<TFeedAction> listAll();
}
