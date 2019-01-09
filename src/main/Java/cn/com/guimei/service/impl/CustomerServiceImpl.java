package cn.com.guimei.service.impl;

import cn.com.guimei.dao.CustomerMapper;
import cn.com.guimei.pojo.Customer;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鹏 on 2019/1/3
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    public Map<String, Object> customerPageList(String num) {
        Map<String,Object> map = new HashMap<String, Object>();
        int pageSize = 6;
        int pageNumber = 1;
        if(num != null && num.length()>0){
            pageNumber = Integer.parseInt(num);
        }
        int pageRecode = customerMapper.totalRecode();
        int totalPage = pageRecode%pageSize == 0 ? pageRecode/pageSize : pageRecode/pageSize+1;
        int pageIndex = (pageNumber - 1)*pageSize;
        List<Customer> customerList = customerMapper.queryAll(pageIndex,pageSize);
        map.put("pageNumber",pageNumber);
        map.put("totalPage",totalPage);
        map.put("pageData",customerList);
//        for(Customer customer : customerList){
//            System.out.println(customer.toString());
//        }
        return map;
    }

    public Map<String, Object> customerUnionPageList(String num, Customer customer) {
        Map<String,Object> map = new HashMap<String, Object>();
        int pageSize = 6;
        int pageNumber = 1;
        if(num != null && num.length()>0){
            pageNumber = Integer.parseInt(num);
        }
        int pageRecode = customerMapper.totalWhereRecode(customer);
        int totalPage = pageRecode%pageSize == 0 ? pageRecode/pageSize : pageRecode/pageSize+1;
        int pageIndex = (pageNumber - 1)*pageSize;
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("pageIndex",pageIndex);
        map1.put("pageSize",pageSize);
        map1.put("customer",customer);
        List<Customer> customerList = customerMapper.customerWherePageList(map1);
        map.put("pageNumber",pageNumber);
        map.put("totalPage",totalPage);
        map.put("pageData",customerList);

        return map;
    }

    public int delById(String id) {
        return customerMapper.delById(id);
    }

    public Customer showCustomerById(String id) {
        return customerMapper.showCustomerById(id);
    }

    public int updateById(Customer customer) {
        return customerMapper.updateById(customer);
    }

    public int addCus(Customer customer) {
        return customerMapper.addCus(customer);
    }
}
