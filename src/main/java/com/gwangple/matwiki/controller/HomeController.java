package com.gwangple.matwiki.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gwangple.matwiki.dto.HomeDto;
import com.gwangple.matwiki.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Resource(name="homeService")
	private HomeService homeService;
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, @Valid HomeDto homeDto, BindingResult bindingResult) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.info("파라미커 체크");
		if(bindingResult.hasErrors()){
			logger.info("잘못된 파라미터!!");
		}else{
			logger.info("파라미터 ok");
		}
		
		//logger.info("test::::::::::::::::: [{}].", map.get("param"));
		//logger.info("test::::::::::::::::: [{}].", map);
		logger.debug("log debug");
		logger.error("log error");
		logger.warn("log warn");
		
		//dto테스트
		logger.info("homeDto = [{}]", homeDto.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		logger.info("formattedDate::::::::::::::::: [{}].", formattedDate);
		//model.addAttribute("serverTime", homeService.getTest() );
		
		return "home";
	}
	
	@RequestMapping(value = "/dbTest", method = RequestMethod.GET)
	public String dbTest(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		model.addAttribute("serverTime", homeService.getTest() );
		//박종대박종대박종대박종대박종대박종대박종대박종대 20170613
		return "home1";
	}
	
}
