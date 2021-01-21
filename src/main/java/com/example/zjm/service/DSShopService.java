package com.example.zjm.service;

import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import org.codehaus.jettison.json.JSONException;

public interface DSShopService {
    void add(DSShop dsShop) throws JSONException;

    void addvalue(DSShopValues dsShopValues);
}
