package com.mvc.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //标注@Controller注解的类会被spring容器管理
public class TestController {
    public TestController(){
        System.out.println("TestController--->intance");
    }
    //如果用的注解的方式,需要在spring-mvc.xml文件中开启
    // <mvc:annotation-driven></mvc:annotation-driven>
    @RequestMapping("/index")
    public String getIndex(){
        System.out.println("++++++");
        return  "redirect:/index.jsp";
    }
    @RequestMapping("/add")
    public ModelAndView add(){
        System.out.println("add");
        return  new ModelAndView("redirect:/index.jsp");
    }
}
