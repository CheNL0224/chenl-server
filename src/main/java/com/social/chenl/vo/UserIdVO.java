package com.social.chenl.vo;

/**
 * @author : lance.chen
 *
 * time   : 2018/04/23
 * desc   : 用户id参数
 * version: 1.0
 */
public class UserIdVO {

    private String userId;

    public UserIdVO() {
    }

    public UserIdVO(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserIdVO{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
