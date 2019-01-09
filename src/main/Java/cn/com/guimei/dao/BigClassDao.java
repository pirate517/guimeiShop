package cn.com.guimei.dao;

import cn.com.guimei.pojo.BigClass;

import java.util.List;

public interface BigClassDao {
    /**
     * 查询所有
     * @return
     */
    List<BigClass> queryAll();

    /**
     * 根据大分类id删除大分类信息
     * @param id
     * @return
     */
    int delById(String id);

    /**
     * 根据大分类id修改大分类的信息
     * @param bigClass
     * @return
     */
    int updateById(BigClass bigClass);

    /**
     * 根据大分类的指定id查询大分类信息
     * @param id
     * @return
     */
    BigClass queryById(String id);

}
