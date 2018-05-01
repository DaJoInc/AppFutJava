package com.ownk.appfut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ownk.appfut.model.IngresoUsuario;


@RestController
public class IngresoUsuarioRestController {
	
	  @RequestMapping(value = "/ing/", method = RequestMethod.POST)
	    public ResponseEntity<List<IngresoUsuario>> listAllUsers(@RequestBody IngresoUsuario ingresoUsuario, UriComponentsBuilder ucBuilder) {
	        List<IngresoUsuario> ingresoUsuarios = new ArrayList<IngresoUsuario>();
	        IngresoUsuario metodo  = null;
	        GestionIngresoUsuarioControllerDB gestionIngresoUsuarioControllerDB = new GestionIngresoUsuarioControllerDB();

	        metodo = gestionIngresoUsuarioControllerDB.ingreso(ingresoUsuario.getNombreUsuario(),ingresoUsuario.getContrasena());
				if (metodo!= null) {
					ingresoUsuarios.add(metodo);
				}

	        if(ingresoUsuarios.isEmpty()){
	            return new ResponseEntity<List<IngresoUsuario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<IngresoUsuario>>(ingresoUsuarios,HttpStatus.OK);
	    }

	}


