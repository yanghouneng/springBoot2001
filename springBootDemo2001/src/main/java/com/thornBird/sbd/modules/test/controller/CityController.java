package com.thornBird.sbd.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbd.modules.common.vo.Result;
import com.thornBird.sbd.modules.test.entity.City;
import com.thornBird.sbd.modules.test.service.CityService;

@RestController       //@RestController=@Controller + @ResponseBody
@RequestMapping("api")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	/*
	 * http://127.0.0.1/api/cities/522
	 * */
	@RequestMapping("/cities/{countryId}")
	List<City> getCityiesByCountryId(@PathVariable int countryId){ //@PathVariable 注解表示该属性通过path路径里通过countryId取的
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		return cities;
	}
	
	/*
	 * http://127.0.0.1/api/cities?currentPage=1&pageSize=10&countryId=522
	 * */
	@RequestMapping("/cities")
	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage,@RequestParam int pageSize,@RequestParam int countryId){
		return cityService.getCitiesByPage(currentPage, pageSize, countryId);
	}
	
	@PostMapping(value="/city",consumes="application/json")
	public Result<City> insertCity(@RequestBody City city){
		return cityService.insertCity(city);
	}

}
