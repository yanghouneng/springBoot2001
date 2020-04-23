
package com.thornBird.sbd.modules.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbd.modules.test.vo.ConfigBean;

@RestController   //@RestController=@Controller + @ResponseBody
@RequestMapping("/api/test")
public class TestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${server.port}")
	private int port;
	@Value("${com.thorn.bird.name}")
	private String name;
	@Value("${com.thorn.bird.age}")
	private int age;
	@Value("${com.thorn.bird.desc}")
	private String desc;
	@Value("${com.thorn.bird.random}")
	private String random;

	@Autowired
	private ConfigBean configBean;

	/**
	 * http://127.0.0.1/api/test/log
	 */
	@RequestMapping("/log")
	@ResponseBody
	public String logTest() {
		// TRACE<DEBUG<INFO<WARN<ERROR
		LOGGER.trace("This is TRACE log.");
		LOGGER.debug("This is DEBUG log.");
		LOGGER.info("This is INFO log.");
		LOGGER.warn("This is WARN log.");
		LOGGER.error("This is ERROR log.333");
		return "this is log test.";
	}

	/**
	 * http://127.0.0.1/api/test/config
	 */
	@RequestMapping("/config")
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("----")
			.append(name).append("----")
			.append(age).append("----")
			.append(desc).append("----")
			.append(random).append("----").append("</br>");
		sb.append(configBean.getName()).append("----")
			.append(configBean.getAge()).append("----")
			.append(configBean.getDesc()).append("----")
			.append(configBean.getRandom()).append("----");
		return sb.toString();
	}
	
	/**
	 * http://127.0.0.1/api/test/appDesc
	 */
	@RequestMapping("/appDesc")
	public String getDesc(){
		return "Hello world!this is spring boot";
	}

}
