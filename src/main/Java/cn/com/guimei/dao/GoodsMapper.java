package cn.com.guimei.dao;

import cn.com.guimei.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鹏 on 2019/1/7
 */
public interface GoodsMapper {

//    级联查询
    int getTotalRecode(Goods goods);
    List<Goods> getPageData(Map<String, Object> map);

//    修改
    int update(Goods goods);

//    删除
    int delete(int id);

//    添加
    int add(Goods goods);

//    修改、添加 按ID查询
    Goods queryById(int id);

//    验证商品名称唯一
    Goods checkGoodsName(String goodsName);
}
