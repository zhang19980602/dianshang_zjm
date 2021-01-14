package com.example.zjm.service;

import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;

public interface DSShuXingService {
    PageResult<DSShuXing> queryAll(PageParam params);

    void add(DSShuXing dsShuXing);

    DSShuXing queryById(Integer id);
}
