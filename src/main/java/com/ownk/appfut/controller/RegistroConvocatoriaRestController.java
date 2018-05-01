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

import com.ownk.appfut.model.RegistroConvocatoria;

@RestController
public class RegistroConvocatoriaRestController {

	@RequestMapping(value = "/regconv/", method = RequestMethod.POST)
    public ResponseEntity<List<RegistroConvocatoria>> listAllUsers(@RequestBody RegistroConvocatoria registroConvocatoria, UriComponentsBuilder ucBuilder) {
        List<RegistroConvocatoria> registroConvocatorias = new ArrayList<RegistroConvocatoria>();
        RegistroConvocatoria metodo  = null;
        GestionRegistroConvocatoriaControllerDB gestionRegistroConvocatoriaControllerDB = new GestionRegistroConvocatoriaControllerDB();
        metodo = gestionRegistroConvocatoriaControllerDB.registro(registroConvocatoria.getIdUsuario());
			if (metodo!= null) {
				registroConvocatorias.add(metodo);
			}

        if(registroConvocatorias.isEmpty()){
            return new ResponseEntity<List<RegistroConvocatoria>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegistroConvocatoria>>(registroConvocatorias,HttpStatus.OK);
    }

}



