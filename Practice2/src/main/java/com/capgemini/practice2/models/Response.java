package com.capgemini.practice2.models;

import java.util.List;

public class Response {
	
	private double gananciaInversion;
	
	private double montoFinal;
	
	private List<Estatus> tabla;

	public double getGananciaInversion() {
		return gananciaInversion;
	}

	public void setGananciaInversion(double gananciaInversion) {
		this.gananciaInversion = gananciaInversion;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(double montoFinal) {
		this.montoFinal = montoFinal;
	}

	public List<Estatus> getTabla() {
		return tabla;
	}

	public void setTabla(List<Estatus> tabla) {
		this.tabla = tabla;
	}
	
	

}
