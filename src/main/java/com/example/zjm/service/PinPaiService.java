package com.example.zjm.service;

import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;

public interface PinPaiService {
    PageResult<DSPinPai> queryAll(PageParam params);

    void add(DSPinPai dsPinPai);

    DSPinPai queryById(Integer id);

    void delete(DSPinPai dsPinPai);

    void update(DSPinPai dsPinPai);
}
