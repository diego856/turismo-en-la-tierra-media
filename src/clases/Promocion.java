package clases;

import java.util.ArrayList;

public class Promocion {

	private String nombre;
	private String tipo;
	private double costo;
	private ArrayList<Atraccion> atracciones;
	private float duracion;
	private boolean ofertada;

	public Promocion(String nombre, String tipo, double costo, ArrayList<Atraccion> atracciones, float duracion) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.atracciones = atracciones;
		this.duracion = duracion;
		this.ofertada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setOfertada(boolean ofertada) {
		this.ofertada = ofertada;
	}

	public double getCosto() {
		return this.costo;
	}
	
	public boolean getOfertada() {
		return this.ofertada;
	}
	
	public float getDuracion() {
		return this.duracion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
}
