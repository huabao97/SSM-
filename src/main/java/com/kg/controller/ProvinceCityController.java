package com.kg.controller;

import com.kg.common.CommonResult;
import com.kg.domain.City;
import com.kg.domain.Province;
import com.kg.service.ProvinceCityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProvinceCityController {
    @Resource
    private ProvinceCityService provinceCityService;

    /**
     * 查询所有省份
     * @return
     */
    @RequestMapping(value="/queryProvince.do")
    @ResponseBody
    public CommonResult queryProvince(){
List<Province> provinceCities=provinceCityService.queryAllProvince();
        CommonResult cr=new CommonResult(0,"查询没有结果",provinceCities);
        if(provinceCities!=null){
cr=new CommonResult(1,"查询成功",provinceCities);
        }
        return cr;
    }
    @RequestMapping(value="/city/addCity.do")
    @ResponseBody
    public CommonResult addCity(City city){
        int row=provinceCityService.addCity(city);
        CommonResult cr=new CommonResult();
        if(row>0){
            cr.setCode(1);
            cr.setMsg("添加城市"+city.getName()+"成功");
            cr.setData(city);
        }else{
            cr.setCode(0);
            cr.setMsg("添加城市失败");
            cr.setData(city);
        }
        return cr;
    }
    @RequestMapping(value="/city/queryCity.do")
    @ResponseBody
    public CommonResult queryCity(Integer id){
        List<City> cityList=provinceCityService.queryCityProvinceId(id);
        CommonResult cr=new CommonResult();
        if(cityList!=null){
cr.setCode(1);
cr.setMsg("查询出"+cityList.size()+"个城市");
cr.setData(cityList);
        }else{
            cr.setCode(0);
            cr.setMsg("查询无结果");
            cr.setData(cityList);
        }
        return cr;
    }
    
    

}
