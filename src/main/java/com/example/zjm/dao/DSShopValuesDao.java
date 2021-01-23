package com.example.zjm.dao;

import com.example.zjm.model.po.DSShopValues;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DSShopValuesDao {

    @Insert("insert into dianshang_shopvalues(proId,attrData,storcks,price)" +
            "value(#{proId},#{attrData},#{storcks},#{price})")
    void addvalue(DSShopValues dsShopValues);
    @Insert("<script>" +
            "insert into  dianshang_shopvalues(proId,attrData,storcks,price)" +
            "values" +
            "<foreach item='list1' collection='list' separator=','>" +
            "(#{list1.proId},#{list1.attrData},#{list1.storcks},#{list1.price})"+
            "</foreach>" +
            "</script>")
    void addPlxz(List<DSShopValues> list1);
    @Select("select * from  dianshang_shopvalues where proId=#{typeId}")
    List<DSShopValues> queryByTypeId(Integer typeId);
    @Delete("delete from dianshang_shopvalues where proId=#{typeId}")
    void delete(Integer typeId);
}
