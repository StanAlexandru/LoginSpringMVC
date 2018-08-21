/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author astan
 */
@Configuration
@ComponentScan(
        basePackages = {"com.jbm.loginspringmvc.*"},
        excludeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    value = EnableWebMvc.class
            )
        }
)
public class RootConfig {
    
}