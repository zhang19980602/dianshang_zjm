package com.example.zjm.dao;

import com.example.zjm.model.po.DSShuXing_Value;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DSShuXing_ValueDao {

    @Select("select * from dianshang_shuxing_value where attId=#{pid}")
    List<DSShuXing_Value> queryAll(Integer pid);
    @Delete("delete from dianshang_shuxing_value where id = #{id}")
    void delete(Integer id);
    @Select("select * from dianshang_shuxing_value where id=#{id}")
    DSShuXing_Value queryById(Integer id);
    @Insert("insert into dianshang_shuxing_value(value,valueCH,attId) value(#{value},#{valueCH},#{attId})")
    void add(DSShuXing_Value dsShuXing_value);
}
