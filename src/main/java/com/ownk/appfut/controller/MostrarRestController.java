package com.ownk.appfut.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ownk.appfut.model.MostrarA;
@RestController

public class MostrarRestController {
	
	@RequestMapping(value = "/in/", method = RequestMethod.GET)
    public ResponseEntity<List<MostrarA>> listAllUsers() {
        List<MostrarA> mostrarAs = new ArrayList<MostrarA>();
        MostrarA metodo  = null;
        GestionMostrarControllerDB gestionIngresoUsuarioControllerDB = new GestionMostrarControllerDB();

        mostrarAs = gestionIngresoUsuarioControllerDB.registro();


        if(mostrarAs.isEmpty()){
            return new ResponseEntity<List<MostrarA>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MostrarA>>(mostrarAs,HttpStatus.OK);
    }

}


