package com.miroshnicheko;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//       registry.addViewController("/").setViewName("index");
//    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver bViewResolver = new InternalResourceViewResolver();
//      // bViewResolver.setViewClass();
//        bViewResolver.setPrefix("/WEB-INF/view");
//        bViewResolver.setSuffix(".html");
//        return bViewResolver;
//    }
}
