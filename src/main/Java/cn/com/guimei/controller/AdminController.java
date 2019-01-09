package cn.com.guimei.controller;

import cn.com.guimei.pojo.Superuser;
import cn.com.guimei.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Superuser superuser,HttpServletRequest request){
        Superuser su = adminService.login(superuser);
            if(su==null){
                request.setAttribute("error","您输入的账户或者密码错误！");
                return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/Login.jsp";
            }
            request.getSession().setAttribute("Superuser",su);
            return "index";

    }
}
