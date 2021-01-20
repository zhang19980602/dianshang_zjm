package com.example.zjm.controller;

import com.example.zjm.model.po.DSShuXing_Value;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSShuXing_ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("queryAll1")
    public ReponseData queryAll1()
    {
        List<DSShuXing_Value> list = dsShuXing_valueService.queryAll1();
        return ReponseData.success(list);
    }
    @PostMapping("delete")
    public ReponseData delete(Integer id)
    {
        dsShuXing_valueService.delete(id);
        return ReponseData.success(null);
    }
    @GetMapping("queryById")
    public ReponseData queryById(Integer id)
    {
        DSShuXing_Value dsShuXing_value= dsShuXing_valueService.queryById(id);
        return ReponseData.success(dsShuXing_value);
    }

    @PostMapping("add")
    public ReponseData add(DSShuXing_Value dsShuXing_value)
    {
        dsShuXing_valueService.add(dsShuXing_value);
        return ReponseData.success(null);
    }
    @PostMapping("update")
    public ReponseData update(DSShuXing_Value dsShuXing_value)
    {
        dsShuXing_valueService.update(dsShuXing_value);
        return ReponseData.success(null);
    }

}
