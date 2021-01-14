package com.example.zjm.dao;

import com.example.zjm.model.po.DSPinPai;
import com.example.zjm.model.vo.PageParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PinPaiDao {

    @Select("<script>  select count(1) from dianshang_pinpai where isdel =0" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            "  </script>")
    Long queryCount(PageParam params);
    @Select("<script>  select * from dianshang_pinpai where isdel =0" +
            " <if test='name != null and name != &quot;&quot;'>  and name  like #{name}</if>" +
            "limit #{startIndex},#{limit} </script>")
    List<DSPinPai> queryByPage(PageParam params);
    @Insert("insert into dianshang_pinpai (name,bandE,imgpath,bandDesc,ord,isdel,createDate,author) value " +
            "                  (#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},#{isdel},#{createDate},#{author})")
    void add(DSPinPai dsPinPai);
   @Select("select * from dianshang_pinpai where id = #{id}")
    DSPinPai queryById(Integer id);
    @Update("update dianshang_pinpai set isdel =#{isdel},updateDate=#{updateDate} where id=#{id}")
    void delete(DSPinPai dsPinPai);
    @Update("update dianshang_pinpai set name=#{name},bandE=#{bandE},bandDesc=#{bandDesc},ord=#{ord},updateDate=#{updateDate},imgpath=#{imgpath},author=#{author} where id =#{id}")
    void update(DSPinPai dsPinPai);
}
