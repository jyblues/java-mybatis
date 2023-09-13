package com.jyblues.javamybatis2.controller.authorization;

import com.jyblues.javamybatis2.util.log.MyLogger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!isValidToken(request)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

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

    private boolean isValidToken(HttpServletRequest request) {
        // JWT 검사 및 관련 정보를 헤더에 추가하는 로직 작성
        String token = request.getHeader("Authorization"); // 예: Bearer 토큰
        // JWT 검사 로직 구현

        //TODO:

        MyLogger.logInfo("JwtInterceptor valid");

        return true;

        // 필요한 정보를 헤더에 추가
//        if (isValidToken) {
//            request.setAttribute("userId", extractedUserId); // 예: 유저 ID
//            return true;
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
    }

}
