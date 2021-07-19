package cn.zyh.service.impl;

import cn.zyh.dao.WorkingDao;
import cn.zyh.dao.impl.WorkingDaoImpl;
import cn.zyh.entity.Working;
import cn.zyh.service.WorkingService;

import java.util.List;

public class WorkingServiceImpl implements WorkingService {
    WorkingDao workingDao=new WorkingDaoImpl();
    @Override
    public List<Working> getAllWorking() {
        return workingDao.getAllWorking();
    }

    @Override
    public int countByType(String type) {
        return workingDao.countByType(type);
    }

    @Override
    public Working getWorkingByID(int id) {
        return workingDao.getWorkingByID(id);
    }

    @Override
    public Integer addWorking(Working working) {
        return workingDao.addWorking(working);
    }
}
