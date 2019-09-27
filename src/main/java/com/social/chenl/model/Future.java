package com.social.chenl.model;

/**
 * @author : lance.chen
 *
 * time   : 2018/07/16
 * desc   : 写给未来
 * version: 1.0
 */
public class Future {

    private String id;
    private String userId;
    private String toMail;
    private String username;
    private String futureInfo;
    private Integer days;
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFutureInfo() {
        return futureInfo;
    }

    public void setFutureInfo(String futureInfo) {
        this.futureInfo = futureInfo;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
