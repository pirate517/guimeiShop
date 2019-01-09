package cn.com.guimei.controller;

import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.GoodsService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 张鹏 on 2019/1/7
 */

@Controller
@RequestMapping("/doGoods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @RequestMapping("/query")
    public String doQuery(String pageNumber, Goods goods, HttpServletRequest request){
        Page<Goods> page = goodsService.goodsQuery(pageNumber,goods);

        Long id = goods.getId()!=null?goods.getId():0;
        String goodsName = goods.getGoodsName()!=null && goods.getGoodsName().length()>0?goods.getGoodsName():"";
        Long goodsSmalId = goods.getGoodsSmalId()!=null?goods.getGoodsSmalId():0;
        Long goodsDiscId = goods.getGoodsDiscId()!=null?goods.getGoodsDiscId():0;
        Long goodsSellerId = goods.getGoodsSellerId()!=null?goods.getGoodsSellerId():0;
        page.setServletURL("/doGoods/query?id="+id+"&goodsName="+goodsName+"&goodsSmalId="+goodsSmalId+"&goodsDiscId="+goodsDiscId+"&goodsSellerId="+goodsSellerId+"&pageNumber=");
        request.setAttribute("Page",page);
        return "showGoods";
    }

    @RequestMapping("/delById")
    public String doDelById(String goodsId,HttpServletRequest request){
        int id = goodsId!=null?Integer.parseInt(goodsId):0;
        int i = goodsService.goodsDeleteById(id);
        if( i == 0){
            request.setAttribute("error","该商品类包含购物车或物流信息，无法删除！");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/doGoods/query";
    }

    @RequestMapping("/queryById")
    public String doQueryById(String id,HttpServletRequest request){
        int i = id!=null && id.length()>0?Integer.parseInt(id):0;
        Goods goods = goodsService.goodsQueryById(i);
        if(goods != null){
            request.setAttribute("gs",goods);
            return "UpdateGoods";
        }
        request.setAttribute("error","进入修改操作失败");
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/doGoods/query";
    }

    @RequestMapping(value = "/checkGoodsName",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String doCheckGoodsName(String goodsName){
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        boolean result = goodsService.checkGoodsName(goodsName);
        System.out.println(goodsName+" "+result);
//        System.out.println(flag);
//        String result = null;
//        if(flag){
//            result = "exists" ;
//        }
//        out.print("{\"result\":\"" + flag + "\"}");
        return JSON.toJSONString(result);
    }

//    @RequestMapping("/checkGoodsName")
//    public void doCheckGoodsName(String goodsName,HttpServletRequest request){
//        boolean flag = goodsService.checkGoodsName(goodsName);
//        String status = null;
//        if(flag){
//            status = "exists1" ;
//        }
//        request.setAttribute("status",status);
//    }

    @RequestMapping("/localAddGoods")
    public String localAddGoods(){
        return "addGoods";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, MultipartFile goodsImages, HttpServletRequest request) {
        String filePath = request.getRealPath("/static/images/goodsImage");
        int i = goodsService.addGoods(goods,goodsImages,filePath);
        if(i==1){
            request.setAttribute("error","图像文件路径不存在！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==2){
            request.setAttribute("error","添加商品失败！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==3){
            request.setAttribute("error","上传文件不能操作5MB！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==4){
            request.setAttribute("error","文件类型非要求的图像格式！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/doGoods/query";
    }
}
