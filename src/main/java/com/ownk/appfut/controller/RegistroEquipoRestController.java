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

import com.ownk.appfut.model.RegistroEquipo;

@RestController
public class RegistroEquipoRestController {
	
	@RequestMapping(value = "/registroeq/", method = RequestMethod.POST)
    public ResponseEntity<List<RegistroEquipo>> listAllUsers(@RequestBody RegistroEquipo registroEquipo, UriComponentsBuilder ucBuilder) {
        List<RegistroEquipo> registroEquipos = new ArrayList<RegistroEquipo>();
        RegistroEquipo metodo  = null;
        GestionRegistroEquipoControllerDB gestionRegistroEquipoControllerDB = new GestionRegistroEquipoControllerDB();
        for (int i = 1; i < 20; i++) {
        metodo = gestionRegistroEquipoControllerDB.registro(registroEquipo.getIdUsuario(),registroEquipo.getNombreEquipo());
			if (metodo!= null) {
				registroEquipos.add(metodo);
			}
        }
        if(registroEquipos.isEmpty()){
            return new ResponseEntity<List<RegistroEquipo>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegistroEquipo>>(registroEquipos,HttpStatus.OK);
    }

}


