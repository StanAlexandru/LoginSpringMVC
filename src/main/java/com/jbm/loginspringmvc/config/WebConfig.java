/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author astan
 */
@Configuration
@ComponentScan("com.jbm.loginspringmvc.*")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = 
                new InternalResourceViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }
    
}
