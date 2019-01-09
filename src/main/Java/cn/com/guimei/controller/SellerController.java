package cn.com.guimei.controller;

import cn.com.guimei.pojo.Seller;
import cn.com.guimei.service.SellerService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张鹏 on 2019/1/8
 */

@Controller
@RequestMapping("/doSeller")
public class SellerController {

    @Resource
    SellerService sellerService;

    @RequestMapping(value = "/ajaxQuery",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String doAjaxQuery(){
        List<Seller> sellerList = sellerService.sellerList();
        return JSONArray.toJSONString(sellerList);
    }
}
