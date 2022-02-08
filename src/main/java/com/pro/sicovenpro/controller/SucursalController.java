package com.pro.sicovenpro.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sicovenpro.model.Persona;
import com.pro.sicovenpro.model.Sucursal;
import com.pro.sicovenpro.repository.SucursalRepo;

@RestController
public class SucursalController {
	
	@Autowired
	public SucursalRepo sucursalRepo;
	
	@GetMapping(value = "/api/listasuc")
	public List<Sucursal> listasuc(){
		return sucursalRepo.findAll();
	}
	
  	@Transactional
	@PostMapping("/api/addsuc") 
	public Sucursal guardarSuc(@RequestBody Sucursal suc) {
		System.out.println("Si llegó...");
//		System.out.println("SUCURSAL::"+suc.getCods()+"-"+suc.getNombre()+"-"+suc.getDirweb()+"-"+suc.getEstado()+"-"+suc.getLugar()+"-"+suc.getLogo()+"-"+suc.getDirlogo());
		System.out.println("GENERALES::"+suc.getGenerales().getCodg()+"-"+suc.getGenerales().getCodven()+"-"+suc.getGenerales().getCodpag() );

		//Insertar datos a SUCURSAL
//		int res1= sucursalRepo.addSucursal(suc.getNombre().toUpperCase(),suc.getDirecc().toUpperCase(),
//										   suc.getDirweb(),1,suc.getLugar().toUpperCase(),"-","-");		
		return suc;
	}

  	@Transactional
	@PutMapping("/api/delsuc/{xcods}")  //DELETE LOGIC
	public int eliminarSucur(@PathVariable int xcods) {
		System.out.println("Proceso ELiminacion..");
		System.out.println("XCODS::"+xcods);
		//ELIMINACION LOGICA
		int res1= sucursalRepo.eliminarSucursal(xcods);		
		return res1;
	}
  	
  	@Transactional
	@PutMapping("/api/habsuc/{xcods}")  //DELETE 
	public int habilitarSucur(@PathVariable int xcods) {
		System.out.println("Proceso Habilitación..");
		System.out.println("XCODS::"+xcods);
		//Insertar datos a SUCURSAL
		int res1= sucursalRepo.habilitarSucursal(xcods);		
		return res1;
	}

  	@Transactional
	@PutMapping(("/api/modsuc/{xcods}"))
	public Sucursal modificarPer(@PathVariable int xcods, @RequestBody Sucursal suc) {
		System.out.println("Si llegó...");
//		System.out.println("SUCURSAL::"+suc.getCods()+"-"+suc.getNombre()+"-"+suc.getDirweb()+"-"+suc.getEstado()+"-"+suc.getLugar()+"-"+suc.getLogo()+"-"+suc.getDirlogo());
		System.out.println("GENERALES::"+suc.getGenerales().getCodg()+"-"+suc.getGenerales().getCodven()+"-"+suc.getGenerales().getCodpag() );
		//validando

		//Insertar datos a SUCURSAL
//		int res1= sucursalRepo.modSucursal(xcods, suc.getNombre().toUpperCase(),suc.getDirecc().toUpperCase(),
//										   suc.getDirweb(),suc.getLugar().toUpperCase());		
		return suc;
	}
  	
}
