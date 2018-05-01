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

import com.ownk.appfut.controller.GestionRegistroControllerDB;
import com.ownk.appfut.model.RegistroPersona;

@RestController
public class RegistroRestController {
	
    @RequestMapping(value = "/prueba/", method = RequestMethod.POST)
    public ResponseEntity<List<RegistroPersona>> listAllUsers(@RequestBody RegistroPersona registroPersona, UriComponentsBuilder ucBuilder) {
        List<RegistroPersona> registroPersonas = new ArrayList<RegistroPersona>();
        RegistroPersona metodo  = null;
        GestionRegistroControllerDB gestionRegistroControllerDB = new GestionRegistroControllerDB();
    
            metodo = gestionRegistroControllerDB.registrar(registroPersona.getNombre(), registroPersona.getApellido(), registroPersona.getTipoDocumento(), registroPersona.getDocumento(), registroPersona.getFechaNacimiento(), registroPersona.getNombreUsuario(), registroPersona.getContrasena(), registroPersona.getIdRol());
			if (metodo!= null) {
				registroPersonas.add(metodo);
			}
	
        if(registroPersonas.isEmpty()){
            return new ResponseEntity<List<RegistroPersona>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegistroPersona>>(registroPersonas,HttpStatus.OK);
    }

}
