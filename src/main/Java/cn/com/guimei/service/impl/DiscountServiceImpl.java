package cn.com.guimei.service.impl;

import cn.com.guimei.dao.DiscountMapper;
import cn.com.guimei.pojo.Discount;
import cn.com.guimei.service.DiscountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张鹏 on 2019/1/8
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Resource
    private DiscountMapper discountMapper;

    public List<Discount> discountList() {
        return discountMapper.discountList();
    }
}
