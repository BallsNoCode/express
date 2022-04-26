package com.kkb.config;

import com.kkb.filter.AccessControlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author APPDE
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(accessControlFilter());
        registration.addUrlPatterns("/admin/index.html");
        registration.addUrlPatterns("/admin/views/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    @Bean
    public AccessControlFilter accessControlFilter(){
        return new AccessControlFilter();
    }

}
