package com.alfimenkov.finalproject;


import com.alfimenkov.finalproject.config.AppConfig;
import com.alfimenkov.finalproject.config.JpaConfig;
import com.alfimenkov.finalproject.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/epam/*"};
    }
}
