package com.thornBird.sbd.modules.test.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestPageController {
	
	@RequestMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		modelMap.addAttribute("template", "test/index");
		return "index";
	}

}
