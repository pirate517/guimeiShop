package cn.com.guimei.dao;

import cn.com.guimei.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

//    按分页查找所有顾客信息
    List<Customer> queryAll(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
    List<Customer> customerWherePageList(Map map);

    int totalRecode();
    int totalWhereRecode(Customer customer);

    Customer showCustomerById(String id);

    int delById(String id);

    Customer updateById(String id);

    int updateById(Customer customer);

    Customer addCustomer();

    int addCus(Customer customer);
}
