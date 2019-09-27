package com.social.chenl.service;

import com.social.chenl.entity.TUser;
import com.social.chenl.result.Result;
import com.social.chenl.vo.LoginVO;
import com.social.chenl.vo.RegisterVO;
import com.social.chenl.vo.UserSearchVO;
import com.social.chenl.vo.UserUpdateVO;

/**
 * @author : lance.chen
 *
 * time   : 2018/02/05
 * desc   : 用户相关
 * version: 1.0
 */
public interface UserService {

    Result register(RegisterVO registerVO);

    Result login(LoginVO loginVO);

    Result resetPassword(RegisterVO registerVO);

    Result updateUser(UserUpdateVO userUpdateVO, String userId);

    Result getUser(String id, String userId);

    Result listRcUser();

    Result searchUser(UserSearchVO userSearchVO);

    TUser userInfo(String id);
}
