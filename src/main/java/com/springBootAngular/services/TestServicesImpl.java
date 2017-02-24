package com.springBootAngular.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootAngular.dao.TestDAO;
import com.springBootAngular.model.Test;


/**
 * service implementation.
 * @author Abhishek Ravi Chandran
 *
 */
@Service("testService")
public class TestServicesImpl implements TestServices{
	
	@Autowired
    private TestDAO testDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServicesImpl.class);

	public List<Test> getAllRecords() {
		LOGGER.debug("service getting records");
		return testDao.getAllRecords();
	}

	public Test getRecordByID(long id) {
		LOGGER.debug("service getting record by id");
		return null;
	}

	public void saveRecord(Test t) {
		LOGGER.debug("service saving record");
		testDao.insertRecord(t);
	}

	public void removeRecord(long id) {
		LOGGER.debug("service removing record by id");
		testDao.deleteRecord(id);
	}

	public void updateRecord(Test t) {
		LOGGER.debug("service updating record");
		testDao.updateRecord(t);
	}

}
