package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import javax.servlet.annotation.WebServlet;
import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
   List<Brand> selectAll();

    /**
     * 新增数据
     * @param brand
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin 开始查询的数据的索引
     * @param size 查询数据的数量
     * @return
     */
    @Select("select * from tb_brand limit #{begin} , #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size")int size);

    /**
     * 数据总数量
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();
}
