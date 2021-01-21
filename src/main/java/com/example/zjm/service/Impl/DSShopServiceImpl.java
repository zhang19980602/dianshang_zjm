package com.example.zjm.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.zjm.dao.DSShopDao;
import com.example.zjm.dao.DSShopValuesDao;
import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.service.DSShopService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DSShopServiceImpl implements DSShopService {
    @Autowired
     private DSShopDao dsShopDao;

    @Autowired
    private DSShopValuesDao dsShopValuesDao;

    @Override
    @Transactional
    public void add(DSShop dsShop) throws JSONException {
        List<DSShopValues> list1= new ArrayList<DSShopValues>();
        List<Object> list= JSONObject.parseArray(dsShop.getAttrData());
        for (int i = 0; i <list.size() ; i++) {
            DSShopValues dsShopValues=JSONObject.parseObject(String.valueOf(list.get(i)),DSShopValues.class);
            list1.add(dsShopValues);
        }
        dsShopValuesDao.addPlxz(list1);
        dsShop.setCreateDate(new Date());
        dsShop.setAuthor("预言家");
        dsShopDao.add(dsShop);
    }

    @Override
    public void addvalue(DSShopValues dsShopValues) {
        dsShopValuesDao.addvalue(dsShopValues);
    }
}
