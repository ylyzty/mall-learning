package com.nudt.demo_01.service.impl;

import com.github.pagehelper.PageHelper;
import com.nudt.demo_01.mbg.mapper.PmsBrandMapper;
import com.nudt.demo_01.mbg.model.PmsBrand;
import com.nudt.demo_01.mbg.model.PmsBrandExample;
import com.nudt.demo_01.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/3/14
 */

/**
 * @Service: 注入Spring容器
 * getBean默认名是类名(首字母小写 —— "pmsBrandServiceImpl")
 * 默认单例
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    /**
     * @Autowired: 装配对象, 默认byType
     * @Resource: 装配对象, 默认byName
     */
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertPmsBrand(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updatePmsBrand(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deletePmsBrandById(id);
    }

    @Override
    public PmsBrand getBrandById(Long id) {
       return brandMapper.selectPmsBrandById(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }
}
