package com.kkb.config;

import com.kkb.filter.AccessControlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(accessControlFilter());
        registration.addUrlPatterns("/user/*");
        registration.addUrlPatterns("/admin/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    @Bean
    public AccessControlFilter accessControlFilter(){
        return new AccessControlFilter();
    }

}
