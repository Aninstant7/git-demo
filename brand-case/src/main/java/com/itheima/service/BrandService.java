package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增数据
     * @param brand
     */
    void add(Brand brand);
    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页显示数据数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

}
