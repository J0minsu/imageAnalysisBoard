package com.toy.msjo.board.interceptor;


import com.toy.msjo.board.domain.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();
        Account loginUser = (Account) session.getAttribute("loginUser");

        if(loginUser == null) {
            response.sendError(404, "Invalid Login Info");
            return false;
        }
        else {
            //setting session time out (seconds) = 3600 = 1 hour
            session.setMaxInactiveInterval(3600);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
