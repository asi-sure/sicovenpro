package com.pro.sicovenpro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamentos")
public class Departamento {

	@Id
	@Column(name="codd")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codd;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private int estado;

	@OneToMany(mappedBy="departamento")
	private List<Lugar> lugar;

/*
	public List<Lugar> getLugar() {
		return lugar;
	}

	public void setLugar(List<Lugar> lugar) {
		this.lugar = lugar;
	}
*/
	public int getCodd() {
		return codd;
	}

	public void setCodd(int codd) {
		this.codd = codd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
