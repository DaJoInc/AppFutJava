package com.ownk.appfut.controller;

import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ownk.appfut.model.RegistroPersona;
import com.ownk.appfut.persistencia.configuracion.DBManagerMyBatisApp;
import com.ownk.appfut.persistencia.dao.Registro;


public class GestionRegistroControllerDB {

	public RegistroPersona registrar(String nombre, String apellido, String tipoDocumento,Integer documento, Date fechaNacimiento,String nombreUsuario, String contrasena, Integer idRol) {


		/*
		 * ==============================================
		 * Se realiza instacia de objetos que se utilizaran 
		 * en el medoto.
		 * ************************************************* 
		 */
		RegistroPersona registro = new RegistroPersona();

		HashMap<Object, Object> parametrosInOout = new HashMap<Object, Object>();
		SqlSession session = null;
		Registro dao = null;
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
			dao = session.getMapper(Registro.class);


			/*
			 * ==============================================
			 * Se se realiza el mapeo de los parametros 
			 * de entrada que necesita el servicio ofrecido por 
			 * la API 
			 * ************************************************* 
			 */
			parametrosInOout.put("p_Id_Persona",null );
			parametrosInOout.put("p_Nombre_Persona",nombre );
			parametrosInOout.put("p_Apellido_Persona",apellido);
			parametrosInOout.put("p_Tipo_Documento",tipoDocumento );
			parametrosInOout.put("p_Documento_Persona",documento );
			parametrosInOout.put("p_Fecha_Nacimiento", fechaNacimiento);
			parametrosInOout.put("p_Id_Usuario",null );
			parametrosInOout.put("p_Nombre_Usuario",nombreUsuario );
			parametrosInOout.put("p_Contrasena_Usuario", contrasena);
			parametrosInOout.put("p_Estado", null);
			parametrosInOout.put("p_Id_Rol",idRol );
			parametrosInOout.put("cod_respuesta",null );
			parametrosInOout.put("msg_respuesta", null);

			dao.registro(parametrosInOout);

			codRespuesta=(String) parametrosInOout.get("cod_respuesta");
			msgRespuesta=(String) parametrosInOout.get("msg_respuesta");

			if (codRespuesta!=null && msgRespuesta!=null) {
				if (codRespuesta.equals("OK")) {
					registro.setNombre(nombre);
					registro.setApellido(apellido);
					registro.setTipoDocumento(tipoDocumento);
					registro.setDocumento(documento);
					registro.setFechaNacimiento(fechaNacimiento);
					registro.setNombreUsuario(nombreUsuario);
					registro.setContrasena(contrasena);
					registro.setIdRol(idRol);
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

