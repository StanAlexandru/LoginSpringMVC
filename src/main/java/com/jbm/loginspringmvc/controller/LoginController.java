/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbm.loginspringmvc.controller;

import com.jbm.loginspringmvc.service.LoginService;
import com.jbm.loginspringmvc.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author astan
 */
@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(
            value = "login",
            method = RequestMethod.GET
    )
    public String loginAction(HttpServletRequest request){        
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        return "login";
    }
    
    @RequestMapping(
            value = "login",
            method = RequestMethod.POST
    )
    public String loginAction(
            HttpServletRequest request,
            @RequestParam String username, 
            @RequestParam String password,
            Model model){
        
        //model.addAttribute("username", username);
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
                
        if(loginService.login(loginUser) != null){
            
            request.getSession().setAttribute("username", username);
            return "redirect:/hello";
            
        } else{
            return "login";            
        }
    }
    
}
