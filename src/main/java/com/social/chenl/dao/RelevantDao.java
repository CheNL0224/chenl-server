package com.social.chenl.dao;

import com.social.chenl.model.Relevant;
import com.social.chenl.vo.RelevantVO;
import com.social.chenl.vo.UserIdVO;

import java.util.List;

public interface RelevantDao {

    Integer relevantTotal(UserIdVO userIdVO);

    List<Relevant> pageRelevant(RelevantVO relevantVO);

    Integer mineReplyTotal(UserIdVO userIdVO);

    List<Relevant> pageMineReply(RelevantVO relevantVO);
}