
package com.example.data_transfer_object.Config;

import com.example.data_transfer_object.interceptors.LoggingHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoggingHandlerInterceptor loggingHandlerInterceptor;

    public WebConfig(LoggingHandlerInterceptor loggingHandlerInterceptor) {
        this.loggingHandlerInterceptor = loggingHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingHandlerInterceptor)
                .addPathPatterns("/students/**");
    }
}

