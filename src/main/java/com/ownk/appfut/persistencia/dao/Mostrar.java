package com.ownk.appfut.persistencia.dao;

import java.util.HashMap;
import java.util.List;

import com.ownk.appfut.model.MostrarA;

public interface Mostrar {

	public String mostrar(HashMap<Object, Object> parametros);

	public List<MostrarA> getAll();
	
}
