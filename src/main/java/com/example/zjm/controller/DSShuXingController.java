package com.example.zjm.controller;

import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSShuXingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/shuxing")
@RestController
public class DSShuXingController {

    @Autowired
    private DSShuXingService dsShuXingService;

    @GetMapping("queryAll")
    public PageResult<DSShuXing> queryAll(PageParam params){
        PageResult<DSShuXing> rs =dsShuXingService.queryAll(params);
        return  rs;
    }

    @PostMapping("add")
    public ReponseData add(DSShuXing dsShuXing){

        dsShuXingService.add(dsShuXing);
        return ReponseData.success(null);
    }

    @GetMapping("queryById")
    public ReponseData queryById(Integer id){

        DSShuXing dsShuXing=dsShuXingService.queryById(id);
        return ReponseData.success(dsShuXing);
    }

    @PostMapping("update")
    public ReponseData update(DSShuXing dsShuXing){
        dsShuXingService.update(dsShuXing);
        return ReponseData.success(null);
    }

}
