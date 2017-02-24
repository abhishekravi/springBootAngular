package com.springBootAngular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Abhishek Ravi Chandran
 * default controller to load index.html
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(IndexController.class);

	 @RequestMapping(method = RequestMethod.GET)
     public String getIndexPage() {
		 logger.debug("in default controller");
		 logger.debug("ret index");
         return "public/index.html";
     }
}
