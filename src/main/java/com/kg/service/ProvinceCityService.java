package com.kg.service;

import com.kg.domain.City;
import com.kg.domain.Province;

import java.util.List;

public interface ProvinceCityService {
    int addCity(City city);
List<Province> queryAllProvince();
List<City> queryCityProvinceId(Integer id);
}
