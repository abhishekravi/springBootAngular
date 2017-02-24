package com.springBootAngular.dao;

import java.util.List;

import com.springBootAngular.model.Test;


/**
 * DAO interface.
 * @author Abhishek Ravi Chandran
 *
 */
public interface TestDAO {

	/**
	 * getting all records.
	 * @return
	 */
	public List<Test> getAllRecords();
	
	/**
	 * to get a record by id.
	 * @param id
	 * @return
	 */
	public Test getRecordByID(long id);
	
	/**
	 * to insert a record.
	 * @param t
	 */
	public void insertRecord(Test t);
	
	/**
	 * to delete a record.
	 * @param id
	 */
	public void deleteRecord(long id);
	
	/**
	 * to update a record.
	 * @param t
	 */
	public void updateRecord(Test t);
}
