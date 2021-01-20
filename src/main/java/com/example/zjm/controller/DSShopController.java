package com.example.zjm.controller;


import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("api/shop")
@RestController
public class DSShopController {
    @Autowired
    private DSShopService dsShopService;


    @PostMapping("add")
    public ReponseData add(DSShop dsShop){

        dsShopService.add(dsShop);
        return ReponseData.success(null);
    }

    @PostMapping("addvalue")
    public ReponseData addvalue(DSShopValues dsShopValues){

        dsShopService.addvalue(dsShopValues);
        return ReponseData.success(null);
    }



}
