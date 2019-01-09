package cn.com.guimei.dao;

import cn.com.guimei.pojo.Superuser;

public interface AdminDao {

    public Superuser login(String userLoginName,String userPassword);

    public Superuser queryById(String id);

    public int updateById(Superuser superuser);

}
