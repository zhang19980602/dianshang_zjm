package com.example.zjm.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.zjm.dao.DSShopDao;
import com.example.zjm.dao.DSShopValuesDao;
import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.po.DSShopValues;
import com.example.zjm.model.vo.PageParam;
import com.example.zjm.model.vo.PageResult;
import com.example.zjm.service.DSShopService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DSShopServiceImpl implements DSShopService {
    @Autowired
     private DSShopDao dsShopDao;

    @Autowired
    private DSShopValuesDao dsShopValuesDao;

    @Override
    @Transactional
    public void add(DSShop dsShop) throws JSONException {
        dsShop.setCreateDate(new Date());
        dsShop.setAuthor("预言家");
        dsShopDao.add(dsShop);
        List<DSShopValues> list1= new ArrayList<DSShopValues>();
        List<Object> list= JSONObject.parseArray(dsShop.getAttrData());
        for (int i = 0; i <list.size() ; i++) {
            DSShopValues dsShopValues=JSONObject.parseObject(String.valueOf(list.get(i)),DSShopValues.class);
            dsShopValues.setProId(dsShop.getId());
            list1.add(dsShopValues);
        }
        dsShopValuesDao.addPlxz(list1);
    }

    @Override
    public void addvalue(DSShopValues dsShopValues) {
        dsShopValuesDao.addvalue(dsShopValues);
    }

    @Override
    public PageResult<DSShop> queryAll(PageParam params) {

        Long count = dsShopDao.queryCount(params);
        //查询某页的数据    1  2 ----   0,2    2,2  ---- 2,2     3,3   ----   4,2
        params.setStartIndex((params.getPage()-1)*params.getLimit());//开始下标
        List<DSShop> cars = dsShopDao.queryByPage(params);
        //构建 layui  table 需要的数据{code：0，msg："",data:[],count:}
        PageResult<DSShop> rs=new PageResult<>(count,cars);
        return rs;
    }

    @Override
    public List<DSShopValues> queryByTypeId(Integer typeId) {
        List<DSShopValues> list=dsShopValuesDao.queryByTypeId(typeId);
        return list;
    }

    @Override
    @Transactional
    public void updateShopvalues(String attr,DSShop dsShop) {
        dsShopDao.update1(dsShop);
        dsShopValuesDao.delete(dsShop.getId());
        List<DSShopValues> list1= new ArrayList<DSShopValues>();
        List<Object> list= JSONObject.parseArray(attr);
        for (int i = 0; i <list.size() ; i++) {
            DSShopValues dsShopValues=JSONObject.parseObject(String.valueOf(list.get(i)),DSShopValues.class);
            list1.add(dsShopValues);
        }
        dsShopValuesDao.addPlxz(list1);
    }

    @Override
    public void delete(DSShop dsShop) {
        dsShop.setIsDel(1);
        dsShop.setUpdateDate(new Date());
        dsShopDao.delete(dsShop);
    }

    @Override
    public DSShop queryById(Integer id) {
        DSShop dsShop=dsShopDao.queryById(id);
        return dsShop;
    }

    @Override
    public void update(DSShop dsShop) {
        dsShopDao.update(dsShop);
    }
}
