package com.offcn.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import com.offcn.entity.PageResult;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(timeout=10000)
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){

        return brandService.findAll();
    }


    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){

       return brandService.findpage(page,rows);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {

            brandService.add(brand);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }


    }
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
             return  new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }

    }
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
       return brandService.findOne(id);
    }
    //删除
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return  new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }

    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page,int rows){
       return brandService.findpage(tbBrand,page,rows);
    }
    @RequestMapping("/selectOptionList")
    public List<Map> get(){

       return brandService.selectOptionList();
    }

}
