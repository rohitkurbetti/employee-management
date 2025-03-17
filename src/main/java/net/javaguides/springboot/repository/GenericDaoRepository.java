package net.javaguides.springboot.repository;

public interface GenericDaoRepository {
	

	<T> jakarta.persistence.Query getGenericDAO(String query);

}
