package com.example.zjm.service.Impl;

import com.example.zjm.dao.DSShopDao;
import com.example.zjm.dao.DSShopValuesDao;
import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.service.DSShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DSShopServiceImpl implements DSShopService {
    @Autowired
     private DSShopDao dsShopDao;

    @Autowired
    private DSShopValuesDao dsShopValuesDao;

    @Override
    public void add(DSShop dsShop) {
        dsShop.setCreateDate(new Date());
        dsShop.setAuthor("预言家");
        DSShopValues dsShopValues = new DSShopValues();
        dsShopDao.add(dsShop);
    }

    @Override
    public void addvalue(DSShopValues dsShopValues) {
        dsShopValuesDao.addvalue(dsShopValues);
    }
}
