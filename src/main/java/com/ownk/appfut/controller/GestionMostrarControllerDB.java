package com.ownk.appfut.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;


import com.ownk.appfut.model.MostrarA;
import com.ownk.appfut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.appfut.persistencia.dao.Mostrar;

public class GestionMostrarControllerDB {
	
	public MostrarA registro(String idConvocatoria,String idEquipo,String nombreEquipo) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		MostrarA registro = new MostrarA();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Mostrar dao = null;
		
		
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
			
			parametrosInOout.put("p_Id_Convocatoria",null );
			parametrosInOout.put("p_Id_Equipo", null);
			parametrosInOout.put("p_Nombre_Equipo", null);
		
			
			dao.mostrar(parametrosInOout);
			
			idConvocatoria=(String) parametrosInOout.get("p_Id_Convocatoria");
			idEquipo=(String) parametrosInOout.get("p_Id_Equipo");
			nombreEquipo=(String) parametrosInOout.get("p_Nombre_Equipo");
		
			if (idConvocatoria!=null) {
				
					registro.setIdConvocatoria(idConvocatoria);
					registro.setIdEquipo(idEquipo);
					registro.setNombreEquipo(nombreEquipo);
				
			}


		}catch (Exception e) {
			
		}finally {
			session.close();
		}

		return registro;

	}

}



