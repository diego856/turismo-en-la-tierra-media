package clases;

public class Atraccion {
	private String nombre;
	private double costo;
	private float duracion;
	private int cupo;
	private String tipo;
	private boolean ofertada;

	public Atraccion(String nombre, double costo, float duracion, int cupo, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.tipo = tipo;
		this.ofertada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public float getDuracion() {
		return this.duracion;
	}
	
	public boolean getOfertada() {
		return this.ofertada;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
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
	
	/*
	@Override
	public String toString() {
		return "La atracción " + nombre + " es del tipo " + tipo + ", tiene un costo de " + costo
				+ " monedas de oro. Cuenta con una duración aproximada de " + duracion
				+ " horas, y consta de un cupo total para " + cupo + " personas.";
	}*/
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public boolean tieneCupo() {
		return this.cupo > 0;
	}
	
	public void descontarCupo() {
		this.cupo--;
	}
}