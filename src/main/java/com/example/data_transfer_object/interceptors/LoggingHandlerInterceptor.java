package com.example.data_transfer_object.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest req,
            HttpServletResponse resp,
            Object handler) {

        System.out.println("Incoming request...");

        System.out.println("Request URL: " + req.getRequestURI());
        System.out.println("HTTP Method: " + req.getMethod());
        System.out.println("Request Parameter: " + req.getQueryString());
        System.out.println("Client IP: " + req.getRemoteAddr());
        System.out.println("Token Headers: " + req.getHeader("token"));

        if(handler instanceof HandlerMethod handlerMethod) {
            System.out.println("Method Name: " + handlerMethod.getMethod().getName());
            System.out.println("Method Class: " + handlerMethod.getBean().getClass().getName());
            System.out.println("Method Bean: " + handlerMethod.getBean().getClass().getSimpleName());
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("After Completion...");
        System.out.println("Response Status: "  + response.getStatus());
        System.out.println("Request completed.....");
    }
}
