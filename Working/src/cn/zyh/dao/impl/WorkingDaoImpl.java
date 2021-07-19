package cn.zyh.dao.impl;

import cn.zyh.dao.DbUtils;
import cn.zyh.dao.WorkingDao;
import cn.zyh.entity.Working;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class WorkingDaoImpl implements WorkingDao {
    private final QueryRunner runner=new QueryRunner();
    @Override
    public List<Working> getAllWorking() {
        List<Working> list=null;
        String sql="select * from working order by creataDate;";
        try {
            list=runner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(Working.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countByType(String title) {
        Number nub=0;
        String sql="select count(1) from working where title=?;";
        try {
            nub=(Number) runner.query(DbUtils.getConnection(),sql,new ScalarHandler<>(),title);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nub.intValue();
    }

    @Override
    public Working getWorkingByID(int id) {
       Working working=null;
        String sql="select * from working where id=?;";
        try {
            working=runner.query(DbUtils.getConnection(),sql,new BeanHandler<>(Working.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return working;
    }

    @Override
    public Integer addWorking(Working working) {
        Integer nub=null;
        String sql="INSERT INTO working(`title`,`content`,`creataDate`,`type`)VALUES(?,?,now(),?);";
        try {
            nub=runner.update(DbUtils.getConnection(),sql,working.getTitle(),working.getContent(),working.getType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nub;
    }
}
