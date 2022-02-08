package com.pro.sicovenpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sicovenpro.model.Lugar;
import com.pro.sicovenpro.repository.LugarRepo;

@RestController
public class LugarController {

	@Autowired
	public LugarRepo lugarRepo;
	
	@GetMapping(value = "/api/listalug")
	public List<Lugar> listalug(){
		return lugarRepo.findAll();
	}
	
}
