package com.example.zjm.service;

import com.example.zjm.model.po.DSType;

import java.util.List;

public interface DSTypeService {
    List<DSType> getData();

    List<DSType>  getDataByPid(Integer pid);

    Integer add(DSType dsType);

    void update(DSType dsType);
}
