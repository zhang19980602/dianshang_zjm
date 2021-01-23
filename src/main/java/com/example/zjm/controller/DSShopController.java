package com.example.zjm.controller;


import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSShopService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/shop")
@RestController
public class DSShopController {
    @Autowired
    private DSShopService dsShopService;


    @GetMapping("queryAll")
    public PageResult<DSShop> queryAll(PageParam params){
        PageResult<DSShop> rs =dsShopService.queryAll(params);
        return  rs;
    }


    @PostMapping("add")
    public ReponseData add(DSShop dsShop) throws JSONException {

        dsShopService.add(dsShop);
        return ReponseData.success(dsShop.getId());
    }

    @GetMapping("queryByTypeId")
    public ReponseData queryByTypeId(Integer typeId){

        List<DSShopValues> list=dsShopService.queryByTypeId(typeId);
        return ReponseData.success(list);
    }


    @PostMapping("addvalue")
    public ReponseData addvalue(DSShopValues dsShopValues){

        dsShopService.addvalue(dsShopValues);
        return ReponseData.success(null);
    }

    @PostMapping("updateShopvalues")
    public ReponseData updateShopvalues(String attr,DSShop dsShop) {

        dsShopService.updateShopvalues(attr,dsShop);
        return ReponseData.success("");
    }

    @PostMapping("delete")
    public ReponseData delete(DSShop dsShop) {

        dsShopService.delete(dsShop);
        return ReponseData.success("");
    }

    @GetMapping("queryById")
    public ReponseData queryById(Integer id) {

      DSShop dsShop=dsShopService.queryById(id);
        return ReponseData.success(dsShop);
    }

    @PostMapping("update")
    public ReponseData update(DSShop dsShop) {

        dsShopService.update(dsShop);
        return ReponseData.success("");
    }



}
