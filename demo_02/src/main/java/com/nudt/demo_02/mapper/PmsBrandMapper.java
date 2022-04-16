package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.PmsBrand;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/12
 */
public interface PmsBrandMapper {

    int insertPmsBrand(PmsBrand pmsBrand);

    int deletePmsBrandById(Long id);

    int updatePmsBrand(PmsBrand pmsBrand);

    PmsBrand selectPmsBrandById(Long id);

    List<PmsBrand> selectAllPmsBrand();
}
