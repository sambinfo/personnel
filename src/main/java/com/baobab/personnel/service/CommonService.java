package com.baobab.personnel.service;

import java.util.List;

public interface CommonService {
	<T> T executeNamedQuerySingle(Class<T> clazz, String req, String[] parameters, Object[] data);

	<T> List<T> executeNamedQueryList(Class<T> clazz, String req, String[] parameters, Object[] data);

}
