package com.example.zjm.service.Impl;

import com.example.zjm.dao.DSDao;
import com.example.zjm.model.po.DSType;
import com.example.zjm.service.DSTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DSTypeServiceImpl implements DSTypeService {
    @Autowired
    private DSDao dsDao;


    @Override
    public List<DSType> getData() {
        List<DSType> list = dsDao.getData();

        return list;
    }

    @Override
    public List<DSType>  getDataByPid(Integer pid) {
        List<DSType> list =dsDao.getDataByPid(pid);
        return list;
    }

    @Override
    public Integer add(DSType dsType) {
        dsType.setCreateDate(new Date());
        dsType.setIsDel(0);
        dsDao.add(dsType);
       Integer id= dsDao.queryDate(dsType.getCreateDate());
        return id;
    }

    @Override
    public void update(DSType dsType) {
        dsType.setUpdateDate(new Date());
        dsDao.update(dsType);
    }
}
