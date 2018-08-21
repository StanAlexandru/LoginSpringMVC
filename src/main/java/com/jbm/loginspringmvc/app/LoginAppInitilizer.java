/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.app;

import com.jbm.loginspringmvc.config.RootConfig;
import com.jbm.loginspringmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author astan
 */
public class LoginAppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class [] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class [] {WebConfig.class};    }

    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }
    
}
