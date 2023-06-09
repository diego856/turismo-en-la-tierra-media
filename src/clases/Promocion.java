package clases;

import java.util.ArrayList;
import java.util.Comparator;

public class Promocion {

	private String nombre;
	private String tipo;
	private double costo;
	private ArrayList<Atraccion> atracciones;
	private float duracion;
	private boolean ofertada;

	// Constructor de Clase
	public Promocion(String nombre, String tipo, double costo, ArrayList<Atraccion> atracciones, float duracion) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.atracciones = atracciones;
		this.duracion = duracion;
		this.ofertada = false;
	}

	// Metodos de acceso (getters)
	public String getNombre() {
		return nombre;
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

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public float getDuracion() {
		return this.duracion;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	// Funciones Auxiliares
	public double precioOriginal() {
		double precioOriginal = 0;
		for (Atraccion atraccion : this.getAtracciones()) {
			precioOriginal += atraccion.getCosto();
		}

		return precioOriginal;
	}

	public String imprimirAtracciones() {
		String listaAtracciones = "[";

		for (int i = 0; i < this.atracciones.size(); i++) {
			if (i < this.atracciones.size() - 1) {
				listaAtracciones += atracciones.get(i).getNombre() + ", ";
			} else {
				listaAtracciones += atracciones.get(i).getNombre() + "]";
			}
		}

		return listaAtracciones;
	}

	static Comparator<Promocion> getPromocionComparador() {
		return new Comparator<Promocion>() {

			@Override
			public int compare(Promocion p1, Promocion p2) {
				if (p1.getCosto() > p2.getCosto()) {
					return -1;
				} else if (p1.getCosto() < p2.getCosto()) {
					return 1;
				} else if (p1.getDuracion() > p2.getDuracion()) {
					return -1;
				} else if (p1.getDuracion() < p2.getDuracion()) {
					return 1;
				}

				return 0;
			}
		};
	}
}
