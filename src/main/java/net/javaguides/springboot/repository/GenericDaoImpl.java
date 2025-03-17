package net.javaguides.springboot.repository;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class GenericDaoImpl implements GenericDaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public <T> Query getGenericDAO(String query) {
		return entityManager.createNativeQuery(query);
	}

}
