package com.ownk.appfut.controller;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.appfut.model.IngresoUsuario;
import com.ownk.appfut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.appfut.persistencia.dao.Ingreso;

public class GestionIngresoUsuarioControllerDB {
	
	public IngresoUsuario ingreso(String nombreUsuario, String contrasena) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		IngresoUsuario ingreso = new IngresoUsuario();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Ingreso dao = null;
		String codUsuario;
		String codRespuesta;
		String msgRespuesta;
		String idUsuario;

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
			dao = session.getMapper(Ingreso.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			
			parametrosInOout.put("p_Nombre_Usuario",nombreUsuario );
			parametrosInOout.put("p_Contrasena_Usuario", contrasena);
	
			parametrosInOout.put("cod_usuario",null);
			parametrosInOout.put("cod_respuesta",null);
			parametrosInOout.put("msg_respuesta", null);
			parametrosInOout.put("r_Usuario", null);
			
			dao.ingreso(parametrosInOout);

			codUsuario=(String) parametrosInOout.get("cod_usuario");
			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");
			idUsuario=(String) parametrosInOout.get("r_Usuario");
			if (codRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					ingreso.setNombreUsuario(nombreUsuario);
					ingreso.setContrasena(contrasena);
					ingreso.setCodUsuario(codUsuario);
					ingreso.setCodRespuesta(codRespuesta);
					ingreso.setMsgRespuesta(msgRespuesta);
					ingreso.setIdUsuario(idUsuario);
					
				}else {
					ingreso.setCodRespuesta(codRespuesta);
					ingreso.setMsgRespuesta(msgRespuesta);
				}
			}else {
				ingreso.setCodRespuesta("ERROR");
				ingreso.setMsgRespuesta("No fue posible ejecutar el servicioA");
			}


		}catch (Exception e) {
			ingreso.setCodRespuesta("ERROR");
			ingreso.setMsgRespuesta("No fue posible ejecutar el servicioB");
		}finally {
			session.close();
		}

		return ingreso;

	}

}

