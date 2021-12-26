package com.kg.service.Impl;

import com.kg.dao.CityDao;
import com.kg.dao.ProvinceDao;
import com.kg.domain.City;
import com.kg.domain.Province;
import com.kg.service.ProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {
    @Resource
    private ProvinceDao provinceDao;
    @Resource
    private CityDao cityDao;
    @Override
    public int addCity(City city) {
        return cityDao.insertCity(city);
    }

    @Override
    public List<Province> queryAllProvince() {
        return provinceDao.selectProvince();
    }

    @Override
    public List<City> queryCityProvinceId(Integer id) {
        return cityDao.selectCityByProvinceId(id);
    }
}
