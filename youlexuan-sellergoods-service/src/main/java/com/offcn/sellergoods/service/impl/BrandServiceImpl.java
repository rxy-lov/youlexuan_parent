package com.offcn.sellergoods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.mapper.TbBrandMapper;
import com.offcn.pojo.TbAddressExample;
import com.offcn.pojo.TbBrand;
import com.offcn.pojo.TbBrandExample;
import com.offcn.sellergoods.service.BrandService;
import com.offcn.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


   @Autowired
    private TbBrandMapper tbBrandMapper;


    public List<TbBrand> findAll() {

        return tbBrandMapper.selectByExample(null);
    }

    public PageResult findpage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public void add(TbBrand brand) {

        tbBrandMapper.insert(brand);
    }

    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKey(brand);
    }

    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    public void delete(Long[] ids) {
        for(Long id:ids){
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    public PageResult findpage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample brandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = brandExample.createCriteria();
        if (brand!=null){
            if (brand.getName()!=null && brand.getName()!=""){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (brand.getFirstChar()!=null && brand.getFirstChar()!=""){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(brandExample);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
