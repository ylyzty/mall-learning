package com.nudt.demo_02.service;

import com.nudt.demo_02.entity.PmsBrand;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/12
 */
public interface PmsBrandService {
    int createBrand(PmsBrand pmsBrand);

    int deleteBrand(Long id);

    int updateBrand(Long id, PmsBrand pmsBrand);

    PmsBrand getBrandById(Long id);

    List<PmsBrand> getAllPmsBrand();

    List<PmsBrand> getPmsBrandPaging(int pageNum, int pageSize);
}
