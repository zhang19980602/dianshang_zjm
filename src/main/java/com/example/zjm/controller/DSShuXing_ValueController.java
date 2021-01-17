package com.example.zjm.controller;

import com.example.zjm.model.po.DSShuXing_Value;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSShuXing_ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/shuxing_value")
public class DSShuXing_ValueController {
    @Autowired
    private DSShuXing_ValueService dsShuXing_valueService;

    @GetMapping("queryAll")
    public ReponseData queryAll(Integer pid)
    {
        List<DSShuXing_Value> list = dsShuXing_valueService.queryAll(pid);
        return ReponseData.success(list);
    }

}
