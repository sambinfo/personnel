package com.baobab.personnel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class CommonServiceImpl implements CommonService {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public <T> T executeNamedQuerySingle(Class<T> clazz, String req, String[] parameters, Object[] data) {
		try {
			TypedQuery<T> query = this.entityManager.createNamedQuery(req, clazz);
			for (int i = 0; i < parameters.length; i++)
				query.setParameter(parameters[i], data[i]); 
			if (!query.getResultList().isEmpty())
				return query.getResultList().get(0); 
			return null;
		} catch (Exception e) {
			return null;  
		} 
	}

	@Override
	public <T> List<T> executeNamedQueryList(Class<T> clazz, String req, String[] parameters, Object[] data) {
		try {
			TypedQuery<T> query = this.entityManager.createNamedQuery(req, clazz);
			if (parameters != null && data != null)
				for (int i = 0; i < parameters.length; i++)
					query.setParameter(parameters[i], data[i]);  
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<T>();
		}		
	}
	
}
