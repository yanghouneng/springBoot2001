package com.thornBird.sbd.modules.test.service;

import java.util.List;

import com.thornBird.sbd.modules.test.entity.Country;


public interface CountryService {

	public Country getCountryById(int countryId);
	public Country getCountryByName(String countryName);

}
