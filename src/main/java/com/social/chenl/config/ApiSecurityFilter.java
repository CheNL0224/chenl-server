package com.social.chenl.config;

import com.alibaba.fastjson.JSON;
import com.social.chenl.entity.TUser;
import com.social.chenl.result.Result;
import com.social.chenl.service.UserService;
import com.social.chenl.util.DigestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lance.chen
 * Api安全过滤
 */
@Component
public class ApiSecurityFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String requestURI = request.getRequestURI();
        logger.info("url is :{}", requestURI);

        boolean notVerify = requestURI.contains("register") || requestURI.contains("reset") || requestURI.contains("login");

        boolean isVerify = requestURI.contains("update") || requestURI.contains("future");

        if(notVerify) {
            filterChain.doFilter(request, servletResponse);
        } else {
            // 安全认证
            String token = request.getHeader("X-App-Token");
            boolean isSuccess;
            if (token == null) {
                isSuccess = false;
            } else {
                String[] split = token.split(DigestUtil.AT);
                if (split.length == DigestUtil.TOKEN_ELEMENTS_NUM) {
                    String userId = split[0];
                    request.setAttribute("userId", userId);
                    TUser tUser = userService.userInfo(userId);
                    if (tUser == null) {
                        isSuccess = false;
                    } else {
                        // 校验token正确性
                        String sign = DigestUtil.generatedToken(userId, tUser.getPassword());
                        isSuccess = sign.equalsIgnoreCase(token);
                    }
                } else {
                    isSuccess = false;
                }
            }
            if (isSuccess) {
                filterChain.doFilter(request, servletResponse);
            } else {
                setErrorResponse(servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 设置错误提示
     */
    private void setErrorResponse(ServletResponse servletResponse) throws IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setStatus(403);
        response.setContentType(CONTENT_TYPE_JSON);
        response.getWriter().print(JSON.toJSONString(Result.error("00403", "安全验证失败")));
    }
}
