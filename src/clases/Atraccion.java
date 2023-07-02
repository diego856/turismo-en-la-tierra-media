package clases;

import java.util.Comparator;

public class Atraccion {
	private String nombre;
	private double costo;
	private float duracion;
	private int cupo;
	private String tipo;
	private boolean ofertada;

	// Constructor de Clase
	public Atraccion(String nombre, double costo, float duracion, int cupo, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.tipo = tipo;
		this.ofertada = false;
	}

	// Metodos de acceso (getters y setters)
	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public float getDuracion() {
		return this.duracion;
	}

	public int getCupo() {
		return cupo;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean getOfertada() {
		return this.ofertada;
	}

	public void setOfertada(boolean ofertada) {
		this.ofertada = ofertada;
	}

	// Funciones auxiliares
	public boolean tieneCupo() {
		return this.cupo > 0;
	}

	public void descontarCupo() {
		this.cupo--;
	}

	static Comparator<Atraccion> getAtraccionComparador() {
		return new Comparator<Atraccion>() {

			@Override
			public int compare(Atraccion a1, Atraccion a2) {
				if (a1.getCosto() > a2.getCosto()) {
					return -1;
				} else if (a1.getCosto() < a2.getCosto()) {
					return 1;
				} else if (a1.getDuracion() > a2.getDuracion()) {
					return -1;
				} else if (a1.getDuracion() < a2.getDuracion()) {
					return 1;
				}

				return 0;
			}
		};
	}
}