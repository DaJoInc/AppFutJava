package com.ownk.appfut.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class ConsultaAgenda {

	public static LinkedList<MostrarA> getContactos()
	   {
	      LinkedList<MostrarA> listaContactos=new LinkedList<MostrarA>();
	      try
	      {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection conexion = DriverManager.getConnection(
	            "jdbc:oracle:thin:@127.0.0.1:1521:XE", "OW_JST_US", "OW_JST_US");
	         Statement st = conexion.createStatement();
	         ResultSet rs = st.executeQuery("select * from EQ_CVCT" );
	         /*
	         while (rs.next())
	         {
	        	 MostrarA contacto = new MostrarA();
	            contacto.setIdConvocatoria(rs.getString("CVCT_CVCT"));
	            contacto.setIdEquipo(rs.getString("CVCT_EQPO"));
	            contacto.setNombreEquipo(rs.getString("CVCT_ESDO"));
	         
	            listaContactos.add(contacto);
	         }
	         */
	         rs.close();
	         st.close();
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaContactos;
	   }
}
