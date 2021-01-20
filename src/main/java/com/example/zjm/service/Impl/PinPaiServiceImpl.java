package com.example.zjm.service.Impl;

import com.example.zjm.dao.PinPaiDao;
import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.service.PinPaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PinPaiServiceImpl implements PinPaiService {
    @Autowired
    private PinPaiDao pinPaiDao;

    @Override
    public PageResult<DSPinPai> queryAll(PageParam params) {
        params.setName("%"+params.getName()+"%");
        Long count = pinPaiDao.queryCount(params);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        params.setStartIndex((params.getPage()-1)*params.getLimit());//开始下标
        List<DSPinPai> cars = pinPaiDao.queryByPage(params);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<DSPinPai> rs=new PageResult<>(count,cars);
        return rs;
    }

    @Override
    public void add(DSPinPai dsPinPai) {
        dsPinPai.setCreateDate(new Date());
        dsPinPai.setIsdel(0);
        dsPinPai.setAuthor("预言家");
        pinPaiDao.add(dsPinPai);
    }

    @Override
    public DSPinPai queryById(Integer id) {
        DSPinPai dsPinPai= pinPaiDao.queryById(id);
        return dsPinPai;
    }

    @Override
    public void delete(DSPinPai dsPinPai) {
        dsPinPai.setUpdateDate(new Date());
        dsPinPai.setIsdel(1);
        pinPaiDao.delete(dsPinPai);
    }

    @Override
    public void update(DSPinPai dsPinPai) {
        dsPinPai.setUpdateDate(new Date());
        pinPaiDao.update(dsPinPai);
    }
}
