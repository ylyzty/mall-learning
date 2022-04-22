package com.nudt.demo_02.service.Impl;

import com.github.pagehelper.PageHelper;
import com.nudt.demo_02.entity.PmsBrand;
import com.nudt.demo_02.mapper.PmsBrandMapper;
import com.nudt.demo_02.service.PmsBrandService;
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
    private PmsBrandMapper pmsBrandMapper;


    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insertPmsBrand(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updatePmsBrand(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deletePmsBrandById(id);
    }

    @Override
    public PmsBrand getBrandById(Long id) {
       return pmsBrandMapper.selectPmsBrandById(id);
    }

    @Override
    public List<PmsBrand> getAllPmsBrand() {
        return pmsBrandMapper.selectAllPmsBrand();
    }

    @Override
    public List<PmsBrand> getPmsBrandPaging(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectAllPmsBrand();
    }
}
