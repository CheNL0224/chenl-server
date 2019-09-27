package com.social.chenl.exception;

import com.social.chenl.constant.Constant;
import com.social.chenl.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("************************ Error Start *******************************");
        logger.error(request.getRequestURI());
        logger.error(e.getMessage(), e);
        logger.error("************************* Error End ********************************");
        return Result.error(Constant.ERROR_CODE_DEBUG, e.getMessage());
    }
}
