package com.nudt.demo_01.mbg.mapper;

import com.nudt.demo_01.mbg.model.PmsBrand;
import com.nudt.demo_01.mbg.model.PmsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

/**
 * @Param: MyBatis提供的作为 Dao 层的注解，作用是用于参数传递，从而可以与SQL中的字段名相对应
 */
public interface PmsBrandMapper {

    /**
     * 手动实现 Mapper
     */
    PmsBrand selectPmsBrandById(Long id);

    int deletePmsBrandById(Long id);

    int insertPmsBrand(PmsBrand pmsBrand);

    int updatePmsBrand(PmsBrand pmsBrand);

    List<PmsBrand> selectAllPmsBrand();


    /**
     * mybatis-generator 逆向工程
     */
    int countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}