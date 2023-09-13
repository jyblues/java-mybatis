package com.jyblues.javamybatis2.util.log;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestLogging(request);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 요청 처리 후 로직을 추가하려면 이 곳에 작성
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 요청 처리가 완료된 후 로직을 추가하려면 이 곳에 작성
    }

    private void requestLogging(HttpServletRequest request) {
        String log = request.getRequestURI();
        if(request.getQueryString() != null) {
            log += "?" + request.getQueryString();
        }

        if(!request.getParameterMap().isEmpty()) {
            log += "\n" + request.getParameterMap().toString();
        }

        MyLogger.logInfo(log);
    }
}
