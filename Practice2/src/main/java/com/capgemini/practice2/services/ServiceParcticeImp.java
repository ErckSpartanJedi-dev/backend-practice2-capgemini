package com.capgemini.practice2.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.capgemini.practice2.models.Estatus;
import com.capgemini.practice2.models.Request;
import com.capgemini.practice2.models.Response;

@Service
public class ServiceParcticeImp implements IServicePractice{

	@Override
	public Response calculo(Request req) {
		Response res = new Response();
		ArrayList<Estatus> tabla = new ArrayList<>();
		double saldoInicial = 0;
		double aportacion = 0;
		double rendimiento = 0;
		double saldoFinal = 0;
		double sumaAportaciones = 0;
		for(int i=0; i<req.getAniosInversion(); i++) {
			if(i == 0) {
				saldoInicial = Math.ceil(req.getInversionInicial());
				aportacion = Math.ceil(req.getAportacionAnual());
			}else {
				saldoInicial = Math.ceil(tabla.get(i-1).getSaldoFinal());
				aportacion = Math.ceil(tabla.get(i-1).getAportacion()*(1+(req.getPorcentajeAnual()/100)));
			}
			sumaAportaciones += aportacion;
			rendimiento = Math.ceil((saldoInicial + aportacion)*(req.getRendimientoInversion()/100));
			saldoFinal = saldoInicial + aportacion + rendimiento;
			
			Estatus est = new Estatus();
			est.setAnio(i+1);
			est.setSaldoInicial(saldoInicial);
			est.setAportacion(aportacion);
			est.setRendimiento(rendimiento);
			est.setSaldoFinal(saldoFinal);
			tabla.add(est);
		}
		double gananciaInversion = saldoFinal - req.getInversionInicial() - sumaAportaciones;
		res.setTabla(tabla);
		res.setMontoFinal(saldoFinal);
		res.setGananciaInversion(gananciaInversion);
		return res;
	}
	
	

}
