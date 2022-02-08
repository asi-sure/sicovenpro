package com.pro.sicovenpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="generales")
public class Generales {
	
	@Id
	@Column(name="codg")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codg;
	
	@Column(name="codven")
	private int codven;

	@Column(name="codpag")
	private int codpag;

	public int getCodg() {
		return codg;
	}

	@OneToOne
	@JoinColumn(name="cods")
	private Sucursal sucursal;

	
	public void setCodg(int codg) {
		this.codg = codg;
	}

	public int getCodven() {
		return codven;
	}

	public void setCodven(int codven) {
		this.codven = codven;
	}

	public int getCodpag() {
		return codpag;
	}

	public void setCodpag(int codpag) {
		this.codpag = codpag;
	}

}
