package com.PPOOII.Laboratorio.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Persona", schema = "PPOOII")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	public int id;
	
	@Column(name="PNOMBRE")
	private String pnombre;
	
	@Column(name="EDAD")
	private int edad;

	
	public Persona () {}
	
	public Persona(String pnombre, int Edad) {
		super();
		this.pnombre = pnombre;
		this.edad = Edad;
	}
	
	public Persona(int Id, String pnombre, int Edad) {
		super();
		this.id = Id;
		this.pnombre = pnombre;
		this.edad = Edad;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPnombre() {
		return pnombre;
	}

	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [id=" + this.id + ", Primer Nombre=" + this.pnombre + ", Edad=" + this.edad + "]";
	}
}
