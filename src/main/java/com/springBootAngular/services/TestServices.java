package com.springBootAngular.services;

import java.util.List;

import com.springBootAngular.model.Test;


/**
 * service interface.
 * @author Abhishek Ravi Chandran
 *
 */

public interface TestServices {

	/**
	 * service to get all records.
	 * @return
	 */
	public List<Test> getAllRecords();
	
	/**
	 * service to get record by id.
	 * @param id
	 * @return
	 */
	public Test getRecordByID(long id);
	
	/**
	 * service to persist a record.
	 * @param t
	 */
	public void saveRecord(Test t);
	
	/**
	 * service to remove a record.
	 * @param id
	 */
	public void removeRecord(long id);
	
	/**
	 * service to update a record.
	 * @param t
	 */
	public void updateRecord(Test t);
}
