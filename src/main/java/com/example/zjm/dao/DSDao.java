package com.example.zjm.dao;

import com.example.zjm.model.po.DSType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface DSDao {

    @Select("select * from dianshang_type where isDel=0")
    List<DSType> getData();
    @Select("select * from dianshang_type where pid=#{pid}")
    List<DSType> getDataByPid(Integer pid);
    @Insert("insert into dianshang_type(name,pid,createDate,isDel)" +
            "value (#{name},#{pid},#{createDate},#{isDel})")
    void add(DSType dsType);
    @Select("select id from dianshang_type where createDate=#{createDate}")
    Integer queryDate(Date createDate);
    @Update("<script>update dianshang_type set updateDate=#{updateDate}" +
            " <if test='name != null and name != &quot;&quot;'>  , name  = #{name}</if>" +
            " <if test='pid != null and pid != &quot;&quot;'>  , pid  = #{pid}</if>" +
            " <if test='isDel != null and isDel != &quot;&quot;'>  , isDel  = #{isDel}</if>" +
              "where id = #{id} </script>")
    void update(DSType dsType);
}
