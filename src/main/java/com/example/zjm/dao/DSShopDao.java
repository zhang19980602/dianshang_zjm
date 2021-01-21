package com.example.zjm.dao;

import com.example.zjm.model.po.DSShop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface DSShopDao {


    @Insert("insert into dianshang_shop(name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            "value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void add(DSShop dsShop);
}
