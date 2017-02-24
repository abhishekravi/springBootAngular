package com.springBootAngular.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springBootAngular.model.Test;


/**
 * DAO implementation.
 * 
 * @author Abhishek Ravi Chandran
 *
 */
@Repository("testDao")
public class TestDAOImpl implements TestDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestDAOImpl.class);

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Test> getAllRecords() {
		LOGGER.debug("getting all records");
		Query q = getEntityManager().createQuery("from Test t", Test.class);
		return q.getResultList();
	}

	public Test getRecordByID(long id) {
		LOGGER.debug("getting record by id");
		Test t = this.getEntityManager().find(Test.class, id);
		return t;
	}

	public void insertRecord(Test t) {
		LOGGER.debug("inserting record");
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	@Transactional
	public void deleteRecord(long id) {
		LOGGER.debug("deleting record");
		EntityManager em = getEntityManager();
		Test t = em.find(Test.class, id);
		
		if (null != t) {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		}
	}

	public void updateRecord(Test t) {
		LOGGER.debug("updating record");
		EntityManager em = getEntityManager();
		Test rec = em.find(Test.class, t.getId());
		rec.setVal(t.getVal());
		em.getTransaction().begin();
		em.persist(rec);
		em.getTransaction().commit();
	}

}
