package com.pro.sicovenpro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lugares")
public class Lugar {

	@Id
	@Column(name="codl")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codl;
		
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private int estado;

	@OneToMany(mappedBy="lugar")
	private List<Sucursal> sucursal;
	
	@ManyToOne
	@JoinColumn(name="codd")
	Departamento departamento;
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getCodl() {
		return codl;
	}

	public void setCodl(int codl) {
		this.codl = codl;
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
