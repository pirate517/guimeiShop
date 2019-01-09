package cn.com.guimei.service;

import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.SmallClass;

import java.util.List;

public interface SmallClassService {
     Page<SmallClass> smallClassQuery(String pageNumber, SmallClass smallClass);
     int smallClassUpdateById(SmallClass smallClass);
     int smallClassDeleteById(int id);
     int smallClassAdd(SmallClass smallClass);
     SmallClass smallClassQueryById(int id);
     List<SmallClass> smallClassList();
}
