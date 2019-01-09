package cn.com.guimei.service.impl;

import cn.com.guimei.dao.SmallClassMapper;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.SmallClass;
import cn.com.guimei.service.SmallClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmallClassServiceImpl implements SmallClassService {
    @Resource
    SmallClassMapper smallClassMapper;

    public Page<SmallClass> smallClassQuery(String num, SmallClass smallClass) {
        int pageNumber = 1;
        int pageSize = 6;
        if(num!=null && num.length()>0){
            pageNumber = Integer.parseInt(num);
        }
        int pageIndex = (pageNumber-1)*pageSize;
        Map<String,Object> pageMap = new HashMap<String, Object>();
        pageMap.put("sc",smallClass);
        pageMap.put("pageIndex",pageIndex);
        pageMap.put("pageSize",pageSize);

        Page<SmallClass> page = new Page<SmallClass>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(smallClassMapper.getTotalRecode(smallClass));
        page.setPageData(smallClassMapper.getPageData(pageMap));
        return page;
    }

    public int smallClassUpdateById(SmallClass smallClass) {
        return 0;
    }

    public int smallClassDeleteById(int id) {

        return smallClassMapper.delete(id);
    }

    public int smallClassAdd(SmallClass smallClass) {
        return 0;
    }

    public SmallClass smallClassQueryById(int id) {
        if(id>0){
            return smallClassMapper.queryById(id);
        }
        return null;
    }

    public List<SmallClass> smallClassList() {
        return smallClassMapper.smallClassList();
    }
}
