package com.nudt.demo_01.service;

import com.nudt.demo_01.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/3/14
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    PmsBrand getBrand(Long id);

    //分页查询
    List<PmsBrand> listBrand(int pageNum, int pageSize);
}
