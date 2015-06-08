package br.com.espiaoamigo.dao;

import java.util.List;

public interface GenericDao<T> {
	
	
	public List<T> findAll();  

	/** 
	 * @param instance 
	 */	
	public T save(T instance);
	
	/** 
	 * @param isntance 
	 */  
	public void delete(T instance);  

}