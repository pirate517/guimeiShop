package cn.com.guimei.service;

import cn.com.guimei.pojo.Customer;

import java.util.Map;

public interface CustomerService {

//    public Page<Customer> queryAll(int pageSize, int pageNumber);

    Map<String,Object> customerPageList(String pageNumber);
    Map<String,Object> customerUnionPageList(String pageNumber,Customer customer);

    int delById(String id);

    Customer showCustomerById(String id);

    int updateById(Customer customer);

    int addCus(Customer customer);
}
