package com.capgemini.practice2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.practice2.models.Request;
import com.capgemini.practice2.services.IServicePractice;

@CrossOrigin(origins = {"http://localhost:4200"})	
@RestController
public class PracticeController {
	
	@Autowired
	private IServicePractice service;
	
	@PostMapping("/calculo")
	public ResponseEntity<?> getCalculo(@RequestBody Request req) {
		
		if(validator(req)) {
			return new ResponseEntity<>("Datos incorrectos", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(service.calculo(req), HttpStatus.OK);
	}
	
	public boolean validator(Request req) {
		boolean validacion = false;
		if(req.getInversionInicial()<1000) {
			validacion = true;
		}
		if(req.getAportacionAnual()<0) {
			validacion = true;
		}
		if(req.getPorcentajeAnual() < 0) {
			validacion = true;
		}
		if(req.getAniosInversion() < 1) {
			validacion = true;
		}
		if(req.getRendimientoInversion() < 1) {
			validacion = true;
		}
		return validacion;
	}

}
