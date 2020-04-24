package com.thornBird.sbd.modules.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbd.modules.common.vo.Result;
import com.thornBird.sbd.modules.test.entity.City;

public interface CityService {
	
	public List<City> getCitiesByCountryId(int countryId);
	
	public PageInfo<City> getCitiesByPage(int currentPage,int PageSize,int countryId);

	public Result<City> insertCity(City city);

}
