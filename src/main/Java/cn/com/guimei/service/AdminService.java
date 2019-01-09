package cn.com.guimei.service;

import cn.com.guimei.pojo.Superuser;

public interface AdminService {

    public Superuser login(Superuser superuser);

    public Superuser queryById(String id);

    public int updateById(Superuser superuser);

}
