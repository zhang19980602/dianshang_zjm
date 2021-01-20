package com.example.zjm.service;

import com.example.zjm.model.po.DSShuXing_Value;

import java.util.List;

public interface DSShuXing_ValueService {
    List<DSShuXing_Value> queryAll(Integer pid);

    void delete(Integer id);

    DSShuXing_Value queryById(Integer id);

    void add(DSShuXing_Value dsShuXing_value);

    void update(DSShuXing_Value dsShuXing_value);

    List<DSShuXing_Value> queryAll1();
}
