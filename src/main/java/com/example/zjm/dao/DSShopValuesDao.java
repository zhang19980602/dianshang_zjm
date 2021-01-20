package com.example.zjm.dao;

import com.example.zjm.model.po.DSShopValues;
import org.apache.ibatis.annotations.Insert;

public interface DSShopValuesDao {

    @Insert("insert into dianshang_shopvalues(proId,attrData,storcks,price)" +
            "value(#{proId},#{attrData},#{storcks},#{price})")
    void addvalue(DSShopValues dsShopValues);
}
