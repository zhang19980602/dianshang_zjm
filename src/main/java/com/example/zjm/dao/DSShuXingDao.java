package com.example.zjm.dao;

import com.example.zjm.model.po.DSShuXing;
import com.example.zjm.model.vo.PageParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
}
