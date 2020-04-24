package com.thornBird.sbd.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbd.modules.test.entity.Country;
import com.thornBird.sbd.modules.test.service.CountryService;

@RestController
@RequestMapping("api")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	/*
	 * http://127.0.0.1/api/country/522
	 * */
	@RequestMapping("/country/{countryId}")
	Country getCityiesByCountryId(@PathVariable int countryId){ //@PathVariable 注解表示该属性通过path路径里通过countryId取的
		Country country = countryService.getCountryById(countryId);
		return country;
	}
	
	/*
	 * http://127.0.0.1/api/country?countryName=China
	 * */
	@RequestMapping("/country")
	public Country getCountryByName(@RequestParam String countryName){
		Country country = countryService.getCountryByName(countryName);
		return country;
	}
}
