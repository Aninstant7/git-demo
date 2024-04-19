package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //执行查询方法
        List<Brand> brands = brandService.selectAll();
        //转为JSON数据
        String jsonString = JSON.toJSONString(brands);
        //写入数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收新增数据页面传过来的json数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用新增数据方法
        brandService.add(brand);
        //提示添加成功
        response.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收要删除的数据的id数组
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //转为int[]
        int[] ids = JSON.parseObject(params, int[].class);
        //调用批量删除方法
        brandService.deleteByIds(ids);
        //提示添加成功
        response.getWriter().write("success");

    }
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //执行查询方法
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        //转为JSON数据
        String jsonString = JSON.toJSONString(pageBean);
        //写入数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }


}

