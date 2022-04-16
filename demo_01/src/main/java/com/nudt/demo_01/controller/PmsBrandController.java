package com.nudt.demo_01.controller;

import com.nudt.demo_01.common.CommonPage;
import com.nudt.demo_01.common.CommonResult;
import com.nudt.demo_01.mbg.model.PmsBrand;
import com.nudt.demo_01.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 * @Author: Lzy
 * @Time: 2022/3/14
 */

/**
 * @Controller: 注入Spring容器
 * @RequestMapping: 映射 URL 到 Controller方法
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * @ResponseBody: 将controller方法返回的数据写入HTTP response body中, 通常返回JSON or XML
     * @return
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    /**
     * @RequestBody: 接收前端传递给后端的json字符串中的数据
     * @param pmsBrand
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success: {}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed: {}", pmsBrand);
        }

        return commonResult;
    }

    /**
     * @PathVariable: 接收请求路径中占位符的值
     * @param id
     * @param pmsBrandDto
     * @param result
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success: {}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed: {}", pmsBrandDto);
        }

        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        CommonResult commonResult;
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            commonResult = CommonResult.success(null);
            LOGGER.debug("deleteBrand success: {}", id);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("deleteBrand failed: {}", id);
        }

        return commonResult;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> getBrand(@PathVariable("id") Long id) {
        CommonResult commonResult;
        PmsBrand pmsBrand = demoService.getBrandById(id);
        if (pmsBrand != null) {
            commonResult = CommonResult.success(pmsBrand);
            System.out.println("查询成功");
            LOGGER.debug("findBrand success: {}", id);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("findBrand failed: {}", id);
        }

        return commonResult;
    }

    /**
     * @RequestParam:  
     * eg: 127.0.0.1:8080/brand/list?pageNum=1&pageSize=3
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize
    ) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
}
