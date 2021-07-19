package cn.zyh.service;

import cn.zyh.entity.Working;

import java.util.List;

public interface WorkingService {
    //获取所有信息
    List<Working> getAllWorking();
    //根据标题查询记录数
    int countByType(String type);
    //根据id查信息
    Working getWorkingByID(int id);
    //添加信息
    Integer addWorking(Working working);
}
