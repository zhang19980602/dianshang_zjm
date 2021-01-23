package com.example.zjm.service;

import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import org.codehaus.jettison.json.JSONException;

import java.util.List;

public interface DSShopService {
    void add(DSShop dsShop) throws JSONException;

    void addvalue(DSShopValues dsShopValues);

    PageResult<DSShop> queryAll(PageParam params);

    List<DSShopValues> queryByTypeId(Integer typeId);

    void updateShopvalues(String attr,DSShop dsShop);

    void delete(DSShop dsShop);

    DSShop queryById(Integer id);

    void update(DSShop dsShop);
}
