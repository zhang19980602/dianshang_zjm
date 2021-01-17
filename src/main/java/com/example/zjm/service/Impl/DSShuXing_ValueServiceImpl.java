package com.example.zjm.service.Impl;

import com.example.zjm.dao.DSShuXing_ValueDao;
import com.example.zjm.model.po.DSShuXing_Value;
import com.example.zjm.service.DSShuXing_ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DSShuXing_ValueServiceImpl implements DSShuXing_ValueService {
    @Autowired
    private DSShuXing_ValueDao dsShuXing_valueDao;

    @Override
    public List<DSShuXing_Value> queryAll(Integer pid) {
        List<DSShuXing_Value> list=dsShuXing_valueDao.queryAll(pid);
        return list;
    }

    @Override
    public void delete(Integer id) {
        dsShuXing_valueDao.delete(id);
    }

    @Override
    public DSShuXing_Value queryById(Integer id) {
        DSShuXing_Value dsShuXing_value=dsShuXing_valueDao.queryById(id);
        return dsShuXing_value;
    }

    @Override
    public void add(DSShuXing_Value dsShuXing_value) {
        dsShuXing_valueDao.add(dsShuXing_value);
    }
}
