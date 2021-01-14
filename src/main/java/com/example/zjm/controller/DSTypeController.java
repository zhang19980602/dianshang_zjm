package com.example.zjm.controller;


import com.example.zjm.model.po.DSType;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.DSTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/type")
public class DSTypeController {
    @Autowired
    private DSTypeService dsTypeService;

    //1    查询所有的分类数据
    @GetMapping("getData")
    public ReponseData getData(){

      List<DSType> list= dsTypeService.getData();
      return ReponseData.success(list);
    }

    //2 查询指定pid的数据
    @GetMapping("getDataByPid")
    public ReponseData getDataByPid(Integer pid){

        List<DSType> list=dsTypeService.getDataByPid(pid);
        return ReponseData.success(list);
    }

    @PostMapping("add")
    public ReponseData add(DSType dsType){

        Integer id=dsTypeService.add(dsType);
        return ReponseData.success(id);
    }

    @PostMapping("update")
    public ReponseData update(DSType dsType){
        dsTypeService.update(dsType);
        return ReponseData.success(null);
    }




}
