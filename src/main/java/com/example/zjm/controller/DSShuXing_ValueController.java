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


}
