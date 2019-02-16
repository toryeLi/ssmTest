package com.demo.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
       // 创建模型和视图对象
        ModelAndView mv=new ModelAndView();
        //默认是转发
        //mv.setViewName("/index.jsp");
        //redirect：重定向（重定向是开启一个新的请求，不可以共享request的数据）
      // mv.setViewName("redirect:/index.jsp");
        // forward 请求转发（是一个请求的延续，可以共享request的数据）
       mv.setViewName("forward:/index.jsp");
        return mv;
    }
}
