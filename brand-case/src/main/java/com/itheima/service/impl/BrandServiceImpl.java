package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1.创建SqlSessionFactoryUtils工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取brandMapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectAll();
        //5.释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取brandMapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.add(brand);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取brandMapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3.获取brandMapper对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4，调用方法
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> rows = mapper.selectByPage(begin, size);
            //查询总记录数
        int totalCount = mapper.selectTotalCount();

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        //5.释放资源
        sqlSession.close();
        return brandPageBean;
    }
}