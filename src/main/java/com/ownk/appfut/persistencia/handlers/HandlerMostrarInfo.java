package com.ownk.appfut.persistencia.handlers;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.ownk.appfut.model.MostrarA;



public class HandlerMostrarInfo implements TypeHandler<Object> {
	  @Override
	  public Object getResult(ResultSet arg0, String arg1) throws SQLException {
	     // TODO Auto-generated method stub
	     return null;
	  }
	  @Override
	  public Object getResult(ResultSet arg0, int arg1) throws SQLException {
	     // TODO Auto-generated method stub
	     return null;
	  }
	  @Override
	  public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		  List<MostrarA> lista = new ArrayList<MostrarA>();
		  Object[] structArray = null;
		  BigInteger valor = null;
		  Object[] structAttr;
		  java.sql.Struct mystruct = null;
		  MostrarA solicitudMostrarEquipo = null;
		  try {
			  structArray = (Object[]) cs.getArray(columnIndex).getArray();
			  if (structArray != null && structArray.length>0) {
				  for (Object structObj : structArray) {
					  solicitudMostrarEquipo = new MostrarA();
					  mystruct = (java.sql.Struct) structObj;

					  structAttr = mystruct.getAttributes();
					  
					  try{
						  BigInteger big = (BigInteger) structAttr[0];
						  valor = big;
					  } catch (Exception e) {
						  valor = null;
					  }
					  solicitudMostrarEquipo.setIdConvocatoria(valor);
					  try{
						  BigInteger big = (BigInteger) structAttr[1];
						  valor = big;
					  } catch (Exception e) {
						  valor = null;
					  }
					  solicitudMostrarEquipo.setIdEquipo(valor);
					  
					  solicitudMostrarEquipo.setNombreEquipo((String) structAttr[2]);
					  
					  lista.add(solicitudMostrarEquipo);

				  }
			  }
		  }catch (Exception e) {
			  lista = null;
		  }
		  return lista;
	  }
	  @Override
	  public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType arg3) throws SQLException {

	  }
	}
