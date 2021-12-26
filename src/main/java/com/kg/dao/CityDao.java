package com.kg.dao;

import com.kg.domain.City;

import java.util.List;

public interface CityDao {
    int insertCity(City city);
    List<City> selectCityByProvinceId(Integer provinceId);
}
