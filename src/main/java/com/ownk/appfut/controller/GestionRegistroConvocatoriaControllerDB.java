package com.ownk.appfut.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.appfut.model.RegistroConvocatoria;
import com.ownk.appfut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.appfut.persistencia.dao.RegistroConv;



public class GestionRegistroConvocatoriaControllerDB {
	
	public RegistroConvocatoria registro(String idUsuario) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		RegistroConvocatoria registro = new RegistroConvocatoria();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		RegistroConv dao = null;
	
		String codRespuesta;
		String msgRespuesta;
	

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
			dao = session.getMapper(RegistroConv.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			
			parametrosInOout.put("p_Id_Usuario",idUsuario );
			parametrosInOout.put("p_Id_Convocatoria", null);
			parametrosInOout.put("p_Id_Equipo", null);
			parametrosInOout.put("p_Estado",null);
			parametrosInOout.put("cod_respuesta",null);
			parametrosInOout.put("msg_respuesta", null);
			
			dao.registro(parametrosInOout);

			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");
		
			if (codRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					registro.setIdUsuario(idUsuario);
					registro.setCodRespuesta(codRespuesta);
					registro.setMsgRespuesta(msgRespuesta);
					
				}else {
					registro.setCodRespuesta(codRespuesta);
					registro.setMsgRespuesta(msgRespuesta);
				}
			}else {
				registro.setCodRespuesta("ERROR");
				registro.setMsgRespuesta("No fue posible ejecutar el servicioA");
			}


		}catch (Exception e) {
			registro.setCodRespuesta("ERROR");
			registro.setMsgRespuesta("No fue posible ejecutar el servicioB");
		}finally {
			session.close();
		}

		return registro;

	}

}



