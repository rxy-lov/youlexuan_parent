package com.offcn.sellergoods.service;

import com.offcn.pojo.TbBrand;
import com.offcn.entity.PageResult;

import java.util.List;

public interface BrandService {
    public List<TbBrand> findAll();
    public PageResult findpage(int pageNum,int pageSize);
    //增加
    public void add(TbBrand brand);
    //修改
    public void update(TbBrand brand);
    //根据id寻找
    public  TbBrand  findOne(Long id);
    //批量删除
    public void delete(Long[] ids);
    //条件查询
    public PageResult findpage(TbBrand tbBrand,int pageNum,int pageSize);

}
