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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sucursales")
public class Sucursal {
	
	@Id
	@Column(name="cods")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cods;
	
//	@Column(name="codl")
//	private int codl;
		
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direcc")
	private String direcc;
	
	@Column(name="dirweb")
	private String dirweb;
	
	@Column(name="estado")
	private int estado;
	
//	@Column(name="lugar")
//	private String lugar;
	
	@Column(name="logo")
	private String logo;

	@Column(name="dirlogo")
	private String dirlogo;
	
	@Column(name="latitud")
	private float latitud;
	
	@Column(name="longitud")
	private float longitud;
	
	@OneToOne(mappedBy="sucursal")
	private Generales generales;
	
	@OneToMany
	@JoinColumn(name="cods")
	private List<Persona> persona;

	@ManyToOne
	@JoinColumn(name="codl")
	Lugar lugar;
	
	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
/*
	public int getCodl() {
		return codl;
	}

	public void setCodl(int codl) {
		this.codl = codl;
	}
*/
	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}

	public Generales getGenerales() {
		return generales;
	}

	public void setGenerales(Generales generales) {
		this.generales = generales;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDirlogo() {
		return dirlogo;
	}

	public void setDirlogo(String dirlogo) {
		this.dirlogo = dirlogo;
	}

	public int getCods() {
		return cods;
	}

	public void setCods(int cods) {
		this.cods = cods;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirecc() {
		return direcc;
	}

	public void setDirecc(String direcc) {
		this.direcc = direcc;
	}

	public String getDirweb() {
		return _isnull(dirweb);
	}

	public void setDirweb(String dirweb) {
		this.dirweb = dirweb;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	//validaciones
	public String _isnull(String valor) {
		if (valor == null)
			valor="-";
		return valor;
	}
}
