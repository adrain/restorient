/**
 * 
 */
package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.model.JPAGreeting;

/**
 * @author apinto
 *
 */
@Repository
@Transactional
public class JPAGreetingRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public JPAGreeting save(JPAGreeting greeting) {
		if(null == greeting.getId()) {
			entityManager.persist(greeting);
		}
		else {
			greeting = entityManager.merge(greeting);
		}
		
		return greeting;
	}
	
	public List<JPAGreeting> findAll() {
		CriteriaQuery<JPAGreeting> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(JPAGreeting.class);
		criteriaQuery.select(criteriaQuery.from(JPAGreeting.class));
		return entityManager.createQuery(criteriaQuery).getResultList();
		
	}
	
}
