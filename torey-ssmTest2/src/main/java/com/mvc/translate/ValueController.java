package com.mvc.translate;
import com.mvc.DTO.BaseDTO;
import com.mvc.deme.Account;
import com.mvc.deme.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller //Controller 是单例的
@RequestMapping(value = "user")//@RequestMapping 根的访问路径
public class ValueController {
    ////////////////////////前端的值传入后端/////////////////////
    //将页面上的值添加到User类中
    /**
     * 最原始的方式，也就是获取servlet中的request中的数据
     * @RequestMapping(value = "/old",,method =RequestMethod.GET) method是请求方式，RequestMethod是一个枚举
     * @param request
     * @return
     */
    @RequestMapping(value = "old") //这里斜杠可以加也可以不加
    public String setUser(HttpServletRequest request){
        System.out.println(request.getParameter("userId"));
        System.out.println(request.getParameter("userName"));
        return  "/index.jsp";
    }
    /**
     * SpringMVC方式
     * @RequestParam 注解就是 拿到当前请求参数所对应的元素所对应的值注入(赋值)到RequestParam的参数中
     * required = false，有也可以，没有也可以，true：必须要有数据， 默认为true
     * defaultValue：默认值
     */
    @RequestMapping(value = "springMvcSetUser")
    public String setUser(@RequestParam(name = "userId",defaultValue = "10002",required = false) Long userId,
                                         @RequestParam(name = "userName",required = false) String userName,
                                         @RequestParam(name = "remark",defaultValue = "默认值") String remark){
        System.out.println("springMvcSetUser:"+userId + "," + userName+","+remark);
        return  "/index.jsp";
    }
    @RequestMapping(value = "springMvcSetUser2")
    public String setUser(User user){
        System.out.println("springMvcSetUser2:"+user.toString());
        return  "/index.jsp";
    }
    /**
     *如果有两个对象需要封装，且两个对象的属性名是相同的，如何处理呢?
     * 错误演示：
     */
    @RequestMapping(value = "springMvcSetUser3")
    public String setUser(User user, Account account){
        System.out.println("springMvcSetUser3:"+user.toString());
        System.out.println("springMvcSetUser3:"+account.toString());
        return  "/index.jsp";
    }
    /**
     *如果有两个对象需要封装，且两个对象的属性名是相同的，如何处理呢?
     * 解决方法：
     */
    @RequestMapping(value = "springMvcSetUser4")
    public String setUser(BaseDTO baseDTO){
        System.out.println("springMvcSetUser4:"+baseDTO.toString());
        return  "/index.jsp";
    }
    ////////////////////////后端的值传入前端/////////////////////
    //后端的值传入前端--第一种方式
    @RequestMapping(value = "getNameByRequest")
    public String requestTest(HttpServletRequest request){
        request.setAttribute("name","小明");
        //注意：这里一定是转发，不然数据传不到前台（默认是转发）
        return "/index.jsp";
    }
    //后端的值传入前端方式2-使用ModelAndView
    @RequestMapping(value = "getNameByModelAndView")
    public ModelAndView modelAndViewTest(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("name","小明，使用ModelAndView从后台传值");
        mv.setViewName("/index.jsp");
        return mv;
    }
    //后端的值传入前端方式3-使用Model
    @RequestMapping(value = "getNameByModel")
    public  String modeTest(Model model){
        model.addAttribute("name","小明，使用Model从后台传值");
        return  "/index.jsp";
    }
    //后端的值传入前端方式4-使用ModelMap
    @RequestMapping(value = "getNameByModelMap")
    public  String modelMapTest(ModelMap modelMap){
        modelMap.addAttribute("name","小明，使用ModelMap从后台传值");
        return "/index.jsp";
    }
    //Model与ModelMap的区别：Model接口有一个Map集合，ModelMap继承于LinkedHashMap，也是一个map集合，这两个没有太大的区别
    //默认将类的首字母小写作为key，可以使用@ModelAttribute注解更改
    @RequestMapping(value = "getNameByModel2")
    public  String modelTest(Model model,@ModelAttribute("ddd") User user){
        user.setUserName("ddd");
        System.out.println("Model:" + model);
        model.addAttribute("name","小明，使用Model从后台传值");
        return  "/index.jsp";
    }
    //默认将类的首字母小写作为key，可以使用@ModelAttribute注解更改
    @RequestMapping(value = "getNameByModelMap2")
    public  String modelMapTest(ModelMap modelMap,Account account){
        account.setUserName("AAA");
        System.out.println("ModelMap:" + modelMap);
        modelMap.addAttribute("name","小明，使用ModelMap从后台传值");
        return "/index.jsp";
    }
    //演示将user.jsp页面的数据传送到后台，数据处理后，在返回到index.jsp页面
    @RequestMapping(value = "getNameByModelMap3")
    public  String modelMapTest(ModelMap modelMap,BaseDTO baseDTO){
        baseDTO.getUser().setUserName(baseDTO.getUser().getUserName()+"数据处理了");
        baseDTO.getAccount().setUserName(baseDTO.getAccount().getUserName()+"数据处理了");
        return "/index.jsp";
    }
}
