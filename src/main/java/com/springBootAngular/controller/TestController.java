package com.springBootAngular.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootAngular.model.Test;
import com.springBootAngular.services.TestServices;


/**
 * test rest controller to serve all test requests
 * @author Abhishek Ravi Chandran
 *
 */
@RestController
public class TestController {

	@Autowired
	TestServices testService;
	
	//logger for debugging
	private static final Logger LOGGER =
			LoggerFactory.getLogger(TestController.class);
	private static Map<Long, Test> map = new HashMap<Long, Test>();
	static{
		Test t = new Test(1, "asd");
		map.put(1l,t);
		t = new Test(2, "asd");
		map.put(2l,t);
	}

	/**
	 * method to get record by id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/test/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Test getRecordByID(@PathVariable("id") long id) {
		LOGGER.debug("in get by id");
		testService.getRecordByID(id);
		Test t = map.get(id);
		return t;
	}
	
	/**
	 * method to fetch all records.
	 * @return
	 */
	@RequestMapping(value = "api/test", method = RequestMethod.GET)
	@ResponseBody
	public List<Test> getRecords() {
		LOGGER.debug("in get");
		List<Test> tests = testService.getAllRecords();
		return tests;
	}
	
	/**
	 * method to create a new record.
	 * @param t
	 */
	@RequestMapping(value = "api/test", method = RequestMethod.POST)
	@ResponseBody
	public void createRecord(@RequestBody Test t) {
		LOGGER.debug("in create");
		testService.saveRecord(t);
	}
	
	/**
	 * method to delete a record by id.
	 * @param id
	 */
	@RequestMapping(value = "/api/test/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecord(@PathVariable("id") long id) {
		LOGGER.debug("in delete");
		testService.removeRecord(id);
	}
	
	/**
	 * method to delete a record by id.
	 * @param id
	 */
	@RequestMapping(value = "/api/test", method = RequestMethod.PUT)
	@ResponseBody
	public void updateRecord(@RequestBody Test t) {
		LOGGER.debug("in update");
		testService.updateRecord(t);
	}
	
}
