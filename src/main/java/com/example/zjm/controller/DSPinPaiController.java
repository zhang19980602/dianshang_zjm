package com.example.zjm.controller;

import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSType;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.model.vo.ReponseData;
import com.example.zjm.service.PinPaiService;
import com.example.zjm.utils.UploadDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/pinpai")
public class DSPinPaiController {
    @Autowired
    private PinPaiService pinPaiService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("queryAll")
    public PageResult<DSPinPai> queryAll(PageParam params){
        PageResult<DSPinPai> rs =pinPaiService.queryAll(params);
        return  rs;
    }

    @PostMapping("add")
    public ReponseData add(DSPinPai dsPinPai){

          pinPaiService.add(dsPinPai);
        return ReponseData.success(null);
    }

    @PostMapping("upload")
    public ReponseData upload(MultipartFile img){

        Map<String, String> map = UploadDown.upload(img, request, "imgFiles");
       String path=map.get("filePath");
       String Qpath="http://192.168.1.43:8080/"+path;
        return ReponseData.success(Qpath);
    }
    @GetMapping("queryById")
    public ReponseData queryById(Integer id){

        DSPinPai dsPinPai=pinPaiService.queryById(id);
        return ReponseData.success(dsPinPai);
    }
    @PostMapping("delete")
    public ReponseData delete(DSPinPai dsPinPai){

        pinPaiService.delete(dsPinPai);
        return ReponseData.success(null);
    }
    @PostMapping("update")
    public ReponseData update(DSPinPai dsPinPai){
        pinPaiService.update(dsPinPai);
        return ReponseData.success(null);
    }

}
