package com.mydemo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Enumeration;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //ogger.info("Incoming Request: Method = {}, URI = {}", request.getMethod(), request.getRequestURI());
        logRequestHeaders(request);
        return true; // Continue the request
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Outgoing Response: Status = {}", response.getStatus());
        //logResponseHeaders(response);
    }

    private void logRequestHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String headerValue = request.getHeader(header);
            logger.info("Request Header: {}={}", header, headerValue);
        }
    }

    private void logRequestParams(HttpServletRequest request) {
        request.getParameterMap().forEach((key, value) -> {
            logger.info("Request Param: {}={}", key, String.join(",", value));
        });
    }
}