package com.example.zjm.dao;

import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DSShuXingDao {
    @Select("<script>  select count(1) from dianshang_shuxing where isDel =0" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam params);
    @Select("<script>  select * from dianshang_shuxing where isDel =0" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            "limit #{startIndex},#{limit} </script>")
    List<DSShuXing> queryByPage(PageParam params);
    @Insert("insert into dianshang_shuxing (name,nameCH,typeId,type,isSKU,isDel,createDate,author) value " +
            "                  (#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    void add(DSShuXing dsShuXing);
    @Select("select * from dianshang_shuxing where id = #{id}")
    DSShuXing queryById(Integer id);
     @Update("update dianshang_shuxing set name = #{name}, nameCH=#{nameCH},typeId=#{typeId}" +
             ",type=#{type},isSKU=#{isSKU},updateDate = #{updateDate},author=#{author} where id =#{id}")
    void update(DSShuXing dsShuXing);
    @Update("update dianshang_shuxing set isDel =#{isDel},updateDate=#{updateDate} where id=#{id}")
    void delete(DSShuXing dsShuXing);
}
