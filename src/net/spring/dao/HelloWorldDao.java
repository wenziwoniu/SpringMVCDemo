package net.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class HelloWorldDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findList() {
		String sql = "SELECT * FROM IT_D_PLAN";
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
}
