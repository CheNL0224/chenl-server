package com.social.chenl.vo;

/**
 * @author : lance.chen
 *
 * time   : 2018/04/22
 * desc   :
 * version: 1.0
 */
public class RelevantVO extends PageVO {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RelevantVO{" +
                "pageNum=" + pageNum +
                ", userId='" + userId + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }
}
