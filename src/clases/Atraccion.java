package clases;

public class Atraccion {
	private String nombre;
	private double costo;
	private float duracion;
	private int cupo;
	private String tipo;

	public Atraccion(String nombre, double costo, float duracion, int cupo, String tipo) throws Exception {
		if (costo > 0 && duracion > 0 && cupo > 0) {
			this.nombre = nombre;
			this.costo = costo;
			this.duracion = duracion;
			this.cupo = cupo;
			this.tipo = tipo;
		} else {
			throw new Exception("La atracción ingresada no es válida.");
		}

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
		return duracion;
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

	@Override
	public String toString() {
		return "La atracción " + nombre + " es del tipo " + tipo + ", tiene un costo de " + costo
				+ " monedas de oro. Cuenta con una duración aproximada de " + duracion
				+ " horas, y consta de un cupo total para " + cupo + " personas.";
	}

}