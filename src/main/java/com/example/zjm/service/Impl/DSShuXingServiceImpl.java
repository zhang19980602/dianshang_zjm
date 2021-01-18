package com.example.zjm.service.Impl;

import com.example.zjm.dao.DSShuXingDao;
import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.service.DSShuXingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DSShuXingServiceImpl implements DSShuXingService {

    @Autowired
    private DSShuXingDao dsShuXingDao;

    @Override
    public PageResult<DSShuXing> queryAll(PageParam params) {
        params.setName(params.getName());
        Long count = dsShuXingDao.queryCount(params);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        params.setStartIndex((params.getPage()-1)*params.getLimit());//开始下标
        List<DSShuXing> cars = dsShuXingDao.queryByPage(params);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<DSShuXing> rs=new PageResult<>(count,cars);
        return rs;
    }

    @Override
    public void add(DSShuXing dsShuXing) {
        dsShuXing.setCreateDate(new Date());
        dsShuXing.setIsDel(0);
        dsShuXingDao.add(dsShuXing);
    }

    @Override
    public DSShuXing queryById(Integer id) {
        DSShuXing dsShuXing=dsShuXingDao.queryById(id);
        return dsShuXing;
    }

    @Override
    public void update(DSShuXing dsShuXing) {
        dsShuXing.setUpdateDate(new Date());
        dsShuXingDao.update(dsShuXing);
    }

    @Override
    public void delete(DSShuXing dsShuXing) {
        dsShuXing.setUpdateDate(new Date());
        dsShuXing.setIsDel(1);
        dsShuXingDao.delete(dsShuXing);
    }

    @Override
    public List<DSShuXing> queryByTypeId(Integer typeId) {
        List<DSShuXing> list =dsShuXingDao.queryByTypeId(typeId);
        return list;
    }
}
