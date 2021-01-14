package com.example.zjm.controller;

import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.service.DSShuXingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
