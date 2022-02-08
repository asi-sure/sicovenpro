package com.pro.sicovenpro.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sicovenpro.model.Sucursal;
import com.pro.sicovenpro.repository.GeneralRepo;

@RestController
public class GeneralController {

	@Autowired
	public GeneralRepo generalRepo;
	
  	@Transactional
	@PutMapping(("/api/modgeneral/{xcods}"))
	public Sucursal addGeneral(@PathVariable int xcods, @RequestBody Sucursal suc) {
		System.out.println("Si llegó...");
//		System.out.println("SUCURSAL::"+suc.getCods()+"-"+suc.getNombre()+"-"+suc.getDirweb()+"-"+suc.getEstado()+"-"+suc.getLugar()+"-"+suc.getLogo()+"-"+suc.getDirlogo());
		System.out.println("GENERALES::"+suc.getGenerales().getCodg()+"-"+suc.getGenerales().getCodven()+"-"+suc.getGenerales().getCodpag() );

		//System.out.println("Cantidad..."+generalRepo.verificarExistencia(xcods));
		if (generalRepo.verificarExistencia(xcods) == 0) {
			int res1= generalRepo.addGenerales(xcods, suc.getGenerales().getCodven(), suc.getGenerales().getCodpag());
		}else {
			int res1= generalRepo.modGenerales(xcods, suc.getGenerales().getCodven(), suc.getGenerales().getCodpag());
		}
	
		return suc;
	}
  	
}
