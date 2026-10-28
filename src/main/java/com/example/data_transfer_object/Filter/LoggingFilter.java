
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
 @Component
 @Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) servletRequest;

        HttpServletResponse res =
                (HttpServletResponse) servletResponse;

        long startTime = System.nanoTime();
        System.out.println(
                "Incoming Request: "
                        + req.getRequestURI()
                        + " | Method: "
                        + req.getMethod()
        );

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long endTime = System.nanoTime();
            long duration = endTime - startTime / 1_000_000;
            System.out.println(
                    "Request Completed: "
                            + req.getRequestURI()
                            + " | Method: "
                            + req.getMethod()
                            + " | Status: "
                            + res.getStatus()
                            + " | Duration: "
                            + duration
            );
        }
    }
}
