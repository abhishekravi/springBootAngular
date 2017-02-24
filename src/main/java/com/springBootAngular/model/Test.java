package com.springBootAngular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Test model.
 * @author Abhishek Ravi Chandran
 *
 */
@Entity
@Table(name="test")
public class Test {
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="val")
	private String val;
	
	public Test(long id, String val){
		this.id = id;
		this.val = val;
	}
	
	public Test(){
		
	}
	
	public Test(Test t){
		this.id = t.id;
		this.val = t.val;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
