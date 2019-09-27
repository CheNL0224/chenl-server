package com.social.chenl.dao;

import com.social.chenl.model.Feed;
import com.social.chenl.vo.FeedSearchVO;
import com.social.chenl.vo.IdVO;

import java.util.List;

public interface FeedDao {

    Integer feedTotal(FeedSearchVO feedSearchVO);

    List<Feed> pageFeed(FeedSearchVO feedSearchVO);

    void viewFeed(IdVO idVO);
}