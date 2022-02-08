package com.pro.sicovenpro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	
	@Id
	@Column(name="codper")
	private int codper;
	
	@Column(name="cods")
	private int cods;

	@Column(name="nombres")
	private String nombres;
	
	@Column(name="ap")
	private String ap;
	
	@Column(name="am")
	private String am;
	
	@Column(name="estado")
	private int estado;
	
	@Column(name="fnac")
	private Date fnac;

	public int getCodper() {
		return codper;
	}

	public void setCodper(int codper) {
		this.codper = codper;
	}

	public int getCods() {
		return cods;
	}

	public void setCods(int cods) {
		this.cods = cods;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}
	
	
}
