package com.example.zjm.dao;

import com.example.zjm.model.po.DSShop;
import com.example.zjm.model.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DSShopDao {


    @Insert("insert into dianshang_shop(name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            "value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true,keyProperty ="id",keyColumn = "id")
    void add(DSShop dsShop);
    @Select("<script>  select count(1) from dianshang_shop where isDel =0 order by id desc" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam params);
    @Select("<script>  select * from dianshang_shop where isDel =0 order by id desc" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            " limit #{startIndex},#{limit}</script>")
    List<DSShop> queryByPage(PageParam params);
  @Update("update dianshang_shop set isDel=#{isDel},updateDate=#{updateDate} where id = #{id} ")
    void delete(DSShop dsShop);
   @Select("select * from dianshang_shop where id = #{id}")
    DSShop queryById(Integer id);
   @Update("update dianshang_shop set name=#{name},title=#{title}," +
           "bandId=#{bandId},productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},updateDate=#{updateDate}" +
           " where id = #{id} ")
    void update(DSShop dsShop);
    @Update("update dianshang_shop set typeId=#{typeId} where id=#{id}")
    void update1(DSShop dsShop);
}
