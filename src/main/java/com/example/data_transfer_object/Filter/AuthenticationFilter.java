package com.example.data_transfer_object.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;


        String resId = UUID.randomUUID().toString();

        res.setHeader("X-Request-Id", resId);

        String token = req.getHeader("token");

        if (token == null || !token.equals("123")) {
            res.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Invalid or missing token"
            );
            return;
        }

        chain.doFilter(req, res);
    }
}




