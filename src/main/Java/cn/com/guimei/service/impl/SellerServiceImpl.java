package cn.com.guimei.service.impl;

import cn.com.guimei.dao.SellerMapper;
import cn.com.guimei.pojo.Seller;
import cn.com.guimei.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张鹏 on 2019/1/8
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerMapper sellerMapper;

    public List<Seller> sellerList() {
        return sellerMapper.sellerList();
    }
}
