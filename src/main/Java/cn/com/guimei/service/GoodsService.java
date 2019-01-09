package cn.com.guimei.service;

import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 张鹏 on 2019/1/7
 */
public interface GoodsService {

    Page<Goods> goodsQuery(String pageNumber, Goods goods);
    int goodsUpdate(Goods goods);
    int goodsDeleteById(int id);
    int goodsAdd(Goods goods);
    Goods goodsQueryById(int id);
    boolean checkGoodsName(String goodsName);
    int addGoods(Goods goods, MultipartFile goodsFile, String filePath);
}
