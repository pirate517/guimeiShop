package cn.com.guimei.controller;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 张鹏 on 2019/1/3
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/customerPageList")
    public String doUserPageList(String pageNumber, HttpServletRequest request){
        Map<String,Object> map = customerService.customerPageList(pageNumber);
        map.put("url","/customer/customerPageList?/*pageNumber=*/");
//        map.put("url","/customer/customerPageList?pageNumber=");
        request.setAttribute("Map",map);
        return "showCustomer";
    }

    @RequestMapping("/unionListCustomer")
    public String doUserUnionPageList(Customer customer, String pageNumber, HttpServletRequest request){
        Map<String,Object> map = customerService.customerUnionPageList(pageNumber,customer);
        map.put("url","/customer/unionListCustomer?id="+customer.getId()+"&cusName"+customer.getCusName()+"&cusSex"+customer.getCusSex()/*+"pageNumber="*/);
//        map.put("url","/customer/unionListCustomer?id="+customer.getId()+"&cusName"+customer.getCusName()+"&cusSex"+customer.getCusSex()+"&cusLoginName"+customer.getCusLoginName()+"&cusBirthday"+customer.getCusBirthday()+"&cusHobby"+customer.getCusHobby()+"&cusEmail"+customer.getCusEmail()+"&cusCode"+customer.getCusCode()+"&pageNumber=");
        request.setAttribute("Map",map);
        return "showCustomer";
    }

    @RequestMapping("/delById")
    public String doDelById(String id,HttpServletRequest request){
        System.out.println("进去了控制器");
        int i = customerService.delById(id);
        if(i <= 0){
            request.setAttribute("error","删除失败！");
            return "showCustomer";
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/customer/customerPageList";
    }

    @RequestMapping("/showCustomerById")
    public String doShowCustomerById(String id,HttpServletRequest request){
        Customer customer = customerService.showCustomerById(id);
        request.setAttribute("cus",customer);
        return "updateCusInfo";
    }

    @RequestMapping("/updateById")
    public String doUpdateById(Customer customer,HttpServletRequest request){
        int i = customerService.updateById(customer);
        if(i <= 0){
            request.setAttribute("error","修改失败！");
            return "showCustomer";
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/customer/customerPageList";
    }

    @RequestMapping("/jump")
    public String doJump(){
        return "addCusInfo";
    }

    @RequestMapping("/addCustomer")
    public String doAddCustomer(Customer customer,HttpServletRequest request){
        int i = customerService.addCus(customer);
        if(i <= 0){
            request.setAttribute("error","修改失败！");
            return "showCustomer";
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/customer/customerPageList";
    }

}