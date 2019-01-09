package cn.com.guimei.dao;

import cn.com.guimei.pojo.Superuser;

/**
 * Created by 张鹏 on 2019/1/3
 */
public interface AdminMapper {

    public Superuser login(Superuser superuser);

    public Superuser queryById(String id);

    public int updateById(Superuser superuser);

}
