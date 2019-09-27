package com.social.chenl.service;

import com.social.chenl.entity.TFuture;
import com.social.chenl.model.Future;
import com.social.chenl.result.Result;
import com.social.chenl.vo.FutureSaveVO;

import java.util.List;

/**
 * @author : lance.chen
 *
 * time   : 2018/07/15
 * desc   : 给未来的消息
 * version: 1.0
 */
public interface FutureService {

    Result saveFuture(FutureSaveVO futureSaveVO, String userId);

    List<Future> listFutureToDay();

    void sendFuture(Future future);

    void updateFutureList(List<TFuture> tFutureList);
}
