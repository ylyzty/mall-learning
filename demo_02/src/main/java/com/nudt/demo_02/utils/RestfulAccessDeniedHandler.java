package com.nudt.demo_02.utils;

import cn.hutool.json.JSONUtil;
import com.nudt.demo_02.common.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Lzy
 * @Time: 2022/4/21
 * @Description: 当访问接口没有权限时, 自定义返回结果
 */

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        /**
         * 获取 PrintWriter对象, 发送文本到客户端
         */
        response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(accessDeniedException.getMessage())));
        response.getWriter().flush();    //刷新输出流
    }
}
