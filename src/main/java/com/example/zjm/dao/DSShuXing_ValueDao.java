package com.example.zjm.dao;

import com.example.zjm.model.po.DSShuXing_Value;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DSShuXing_ValueDao {

    @Select("select * from dianshang_shuxing_value where attId=#{pid} and isDel=0")
    List<DSShuXing_Value> queryAll(Integer pid);
    @Update("update dianshang_shuxing_value set isDel=1 where id=#{id}")
    void delete(Integer id);
    @Select("select * from dianshang_shuxing_value where id=#{id}")
    DSShuXing_Value queryById(Integer id);
    @Insert("insert into dianshang_shuxing_value(value,valueCH,attId,isDel) value(#{value},#{valueCH},#{attId},#{isDel})")
    void add(DSShuXing_Value dsShuXing_value);
    @Update("update dianshang_shuxing_value set value=#{value},valueCH=#{valueCH} where id=#{id}")
    void update(DSShuXing_Value dsShuXing_value);
    @Select("select * from dianshang_shuxing_value")
    List<DSShuXing_Value> queryAll1();
}
