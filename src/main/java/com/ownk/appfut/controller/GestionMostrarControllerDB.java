package com.ownk.appfut.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.ownk.appfut.model.MostrarA;
import com.ownk.appfut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.appfut.persistencia.dao.Mostrar;

public class GestionMostrarControllerDB {
	
	@SuppressWarnings("unchecked")
	public List<MostrarA> registro() {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Mostrar dao = null;
		List<MostrarA> respuestaPlsql = null;
		
		String setCodRespuesta;
		String setMsgRespuesta;
		//String idUsuario;

		/*
		 * ==============================================
		 * Se obtiene la session de la conexion JDBC con el
		 * framework de persistencia de la fabrica creada 
		 * en la clase DBManagerMyBatisBDApoyoConfig
		 * ************************************************* 
		 */
		session = DBManagerMyBatisApp.openSession();

		
		try {

			/*
			 * ==============================================
			 * Se obtiene el mapper declarado en la interfaz 
			 * GestionPINPaynetDao que posteriormente sera llamada 
			 * con el Mapa parametrosInOout para orquestar los parametros 
			 * y los handlers
			 * ************************************************* 
			 */
			dao = session.getMapper(Mostrar.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
	
			respuestaPlsql = dao.getAll();
			
			//respuestaPlsql = (List<MostrarA>) parametrosInOout.get("p_Lista_Convocatorias");

			
			if (respuestaPlsql!=null && !respuestaPlsql.isEmpty()) {
				
				return respuestaPlsql;
				
			}


		}catch (Exception e) {
			System.out.println(e);
			
		}finally {
			session.close();
		}

		return null;

	}

}



