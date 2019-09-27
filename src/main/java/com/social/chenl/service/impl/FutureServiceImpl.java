package com.social.chenl.service.impl;

import com.social.chenl.dao.FutureDao;
import com.social.chenl.entity.TFuture;
import com.social.chenl.mapper.TFutureMapper;
import com.social.chenl.model.Future;
import com.social.chenl.result.Result;
import com.social.chenl.service.FutureService;
import com.social.chenl.util.DateUtil;
import com.social.chenl.util.ParamUtil;
import com.social.chenl.vo.FutureSaveVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : lance.chen
 *
 * time   : 2018/07/15
 * desc   : 给未来的消息
 * version: 1.0
 */
@Service
public class FutureServiceImpl implements FutureService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TFutureMapper futureMapper;

    @Autowired
    private FutureDao futureDao;

    @Override
    public Result saveFuture(FutureSaveVO futureSaveVO, String userId) {
        Result result = Result.success();

        // 参数校验
        Integer type = futureSaveVO.getType();
        String mail = futureSaveVO.getMail();
        Integer startNum = futureSaveVO.getStartNum();
        Integer endNum = futureSaveVO.getEndNum();
        String futureInfo = futureSaveVO.getFutureInfo();

        if (type == null) {
            result.setCodeAndMsg("00112", "type必传");
            return result;
        }

        boolean isNotMail = type == 1 && StringUtils.isEmpty(mail);
        boolean isNotNum = startNum == null && endNum == null;
        if (isNotMail || StringUtils.isEmpty(futureInfo) || isNotNum) {
            result.setCodeAndMsg("00113", "必填参数存在空");
            return result;
        }

        // 类型限定
        if (type != 1) {
            type = 0;
        } else {
            // 邮箱校验
            if (!ParamUtil.isMail(mail)) {
                result.setCodeAndMsg("00105", "邮箱格式错误");
                return result;
            }
        }

        // 展示时间
		Integer num = null;
        int days;
        Date showTime;
        if (startNum == null || endNum == null) {
            if (endNum == null) {
                num = startNum;
            }

            if (startNum == null) {
                num = endNum;
            }
        } else {
            if (endNum.equals(startNum)) {
                num = endNum;
            }

            int tmp;
            if (startNum > endNum) {
                tmp = startNum;
                startNum = endNum;
                endNum = tmp;
            }
        }
		
		if (num != null) {
            days = DateUtil.nextNum(1, num * 30);
            showTime = DateUtil.nextDay(days);
        } else {
			showTime = DateUtil.nextMonth(DateUtil.nextNum(startNum, endNum));
			days = DateUtil.getTermDays(new Date(), showTime);
		}

        // 保存
        TFuture tFuture = new TFuture();
        tFuture.setId(ParamUtil.getUUID());
        tFuture.setUserId(userId);
        tFuture.setType(type);
        tFuture.setToMail(mail);
        tFuture.setDays(days);
        tFuture.setShowTime(showTime);
        tFuture.setFutureInfo(futureInfo);
        tFuture.setState(1);
        futureMapper.insertSelective(tFuture);

        return result;
    }

    @Override
    public List<Future> listFutureToDay() {
        return futureDao.listFutureToDay();
    }

    @Override
    public void sendFuture(Future future) {

    }

    @Override
    public void updateFutureList(List<TFuture> tFutureList) {
        for (TFuture tFuture : tFutureList) {
            futureMapper.updateByPrimaryKeySelective(tFuture);
        }
    }
}
