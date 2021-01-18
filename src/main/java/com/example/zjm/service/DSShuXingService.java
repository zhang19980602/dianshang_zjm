package com.example.zjm.service;

import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;

import java.util.List;

public interface DSShuXingService {
    PageResult<DSShuXing> queryAll(PageParam params);

    void add(DSShuXing dsShuXing);

    DSShuXing queryById(Integer id);

    void update(DSShuXing dsShuXing);

    void delete(DSShuXing dsShuXing);

    List<DSShuXing> queryByTypeId(Integer typeId);
}
