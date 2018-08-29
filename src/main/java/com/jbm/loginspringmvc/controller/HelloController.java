/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author astan
 */
@Controller
public class HelloController {
    
    @RequestMapping(
            value = "hello",
            method = RequestMethod.GET)
    public String helloAction(HttpServletRequest request){
        
        Object sessionUsername = request.getSession().getAttribute("username");
        
        if(StringUtils.isEmpty(sessionUsername)){
            return "redirect:/login";
        }
        
        return "hello";
    
    }
    
}
