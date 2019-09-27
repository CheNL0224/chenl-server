package com.social.chenl.dao;

import com.social.chenl.model.Future;

import java.util.List;

/**
 * @author : lance.chen
 * e-mail  : bafs.jy@live.com
 * time    : 2018/10/02
 * desc    : 写给未来相关
 * version : 1.0
 */
public interface FutureDao {

    /**
     * 今天需要发送的消息
     */
    List<Future> listFutureToDay();
}
