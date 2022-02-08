package com.pro.sicovenpro.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sicovenpro.model.Departamento;
import com.pro.sicovenpro.model.Sucursal;
import com.pro.sicovenpro.repository.DepartamentoRepo;


@RestController
public class DepartamentoController {

	@Autowired
	public DepartamentoRepo departamentoRepo;	

	@GetMapping(value = "/api/listadep")
	public List<Departamento> listadep(){
		return departamentoRepo.findAll();
	}
	
	@GetMapping(value = "/api/listadepfiltrado/{xcodd}")
	public List<Departamento> listadepFiltrado(@PathVariable int xcodd){
		System.out.println("DEPARTAMENTO::"+xcodd);
		int xest1=0, xest2=1;
		if (xcodd==0) {xest2=0;}
		if (xcodd==1) {xest1=1;}
		return departamentoRepo.listaDeparFiltro(xest1, xest2);
	}
	
  	@Transactional
	@PostMapping("/api/adddep") 
	public Departamento guardarDep(@RequestBody Departamento dep) {
		System.out.println("Si llegó...");
		System.out.println("DEPARTAMENTO::"+dep.getCodd()+"-"+dep.getNombre()+"-"+dep.getEstado());
		
		//Insertar datos a DEPARTAMENTO
		int res1= departamentoRepo.addDepar(dep.getNombre().toUpperCase(), 1);
		
		return dep;
	}
  	
  	@Transactional
	@PutMapping(("/api/moddep/{xcodd}"))
	public Departamento modificarPer(@PathVariable int xcodd, @RequestBody Departamento dep) {
  		System.out.println("DEPARTAMENTO::"+dep.getCodd()+"-"+dep.getNombre()+"-"+dep.getEstado());

		//MODFICAR
		int res1= departamentoRepo.modDepar(xcodd, dep.getNombre().toUpperCase());		
		return dep;
	}
  	
  	@Transactional
	@PutMapping("/api/deldepar/{xcodd}")  //DELETE LOGIC
	public int eliminarDepar(@PathVariable int xcodd) {
		System.out.println("Proceso ELiminacion..");
		System.out.println("XCODD::"+xcodd);
		//ELIMINACION LOGICA
		int res1= departamentoRepo.delDepar(xcodd);		
		return res1;
	}
  	
  	@Transactional
	@PutMapping("/api/habdepar/{xcodd}")  //DELETE LOGIC
	public int habilitarDepar(@PathVariable int xcodd) {
		System.out.println("Proceso HABILITAR..");
		System.out.println("XCODD::"+xcodd);
		//ELIMINACION LOGICA
		int res1= departamentoRepo.habDepar(xcodd);		
		return res1;
	}
  	
}
