package com.social.chenl.dao;

import com.social.chenl.model.User;
import com.social.chenl.vo.LoginVO;

import java.util.List;

public interface UserDao {

    User login(LoginVO loginVO);

    /** 获取最新的uid */
    Integer getNewUid();

    List<User> listRcUser();
}