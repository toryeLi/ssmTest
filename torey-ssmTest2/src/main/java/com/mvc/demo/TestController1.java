package com.mvc.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller //标注@Controller注解的类会被spring容器管
@RequestMapping("test1")
public class TestController1 {
    public TestController1(){
        System.out.println("TestController1--->intance");
    }
    //如果用的注解的方式,需要在spring-mvc.xml文件中开启
    // <mvc:annotation-driven></mvc:annotation-driven>
    @RequestMapping("/index")
    public String getIndex(){
        System.out.println("testController1-->++++++");
        return  "redirect:/index.jsp";
    }
    @RequestMapping("/add")
    public ModelAndView add(){
        System.out.println("testController1-->add");
        return  new ModelAndView("redirect:/index.jsp");
    }
    //返回json，有两种方式 1 直接响应出一个json字符串 2  使用jackson
    //1 直接响应出一个json字符串
    //@ResponseBody  返回的数据会自动转换为json
    //@RequestMapping("/json.do")
    //@RequestMapping("/json.action") 后缀建议是.do或者.action,不可以是.html
    @RequestMapping("/json")
    public @ResponseBody Map<String,Object> mapJson(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","torey");
        map.put("sex","男");
        map.put("birth","1988.10.05");
        return  map;
    }
}
