package clases;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	protected String preferencia;
	protected double dineroDisponible;
	protected float tiempoDisponible;
	protected String nombre;

	// Constructor de Clase
	public Usuario(String nombre, String preferencia, double dineroDisponible, float tiempoDisponible) {
		this.preferencia = preferencia;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.nombre = nombre;
	}

	// Metodos de acceso (getters)
	public String getPreferencia() {
		return preferencia;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	public float getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	// Funciones auxiliares
	private boolean tieneTiempo(float duracion) {
		return this.tiempoDisponible >= duracion;
	}

	private boolean tieneDinero(double costo) {
		return this.dineroDisponible >= costo;
	}

	private void descontarTiempo(float tiempo) {
		this.tiempoDisponible -= tiempo;
	}

	private void descontarDinero(double dinero) {
		this.dineroDisponible -= dinero;
	}

	private boolean tieneTiempoYDinero(float duracion, double dinero) {
		return this.tieneTiempo(duracion) && this.tieneDinero(dinero);
	}

	private boolean esPromocionDePreferencia(String tipoPromocion) {
		return this.preferencia.equals(tipoPromocion);
	}

	private boolean esAtraccionDePreferencia(String tipoAtraccion) {
		return this.preferencia.equals(tipoAtraccion);
	}

	// Funciones principales
	public void recibirSugerencias(ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones, FileWriter file,
			Archivo archivo) {
		// Se reciben las atracciones y promociones ya ordenadas segun el criterio de
		// oferta
		ArrayList<Promocion> promocionesAceptadas = new ArrayList<>();
		ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<>();
		double costoTotal = 0;
		float duracionTotal = 0;
		
		Scanner reader = new Scanner(System.in);

		String[] inicioCliente = new String[5];
		inicioCliente[0] = Values.Separador;
		inicioCliente[1] = Values.Separador;
		inicioCliente[2] = "Nombre de Usuario: " + this.getNombre();
		inicioCliente[3] = Values.Separador;
		inicioCliente[4] = "Itinerario:\n";

		archivo.agregarTextoEnArchivo(inicioCliente, file);

		// Se comienza tratando de ofertar promociones que coincidan con su preferencia,
		// y para las cuales tenga tiempo y dinero disponible
		for (Promocion promocion : promociones) {
			if (esPromocionDePreferencia(promocion.getTipo())
					&& this.tieneTiempoYDinero(promocion.getDuracion(), promocion.getCosto())) {
				boolean puedeOfertar = true;

				// Se evalua si la atraccion tiene cupo y no fue ofertada anteriormente
				for (Atraccion atraccion : promocion.getAtracciones()) {
					if (atraccion.getOfertada() || !atraccion.tieneCupo()) {
						puedeOfertar = false;
						break;
					}
				}

				// Se oferta la promocion
				if (puedeOfertar) {
					promocionesAceptadas = ofertarPromocion(reader, promocion, file, archivo);
					if(!promocionesAceptadas.isEmpty()) {
						for (Promocion promo : promocionesAceptadas) {
							costoTotal += promo.getCosto();
							duracionTotal += promo.getDuracion();
						}
					}
				}
			}
		}

		// Se continua ofertando atracciones de su preferencia, siempre y cuando tenga
		// tiempo, dinero y haya cupo
		for (Atraccion atraccion : atracciones) {
			if (!atraccion.getOfertada() && esAtraccionDePreferencia(atraccion.getTipo()) && atraccion.tieneCupo()
					&& this.tieneTiempoYDinero(atraccion.getDuracion(), atraccion.getCosto())) {
				atraccionesAceptadas = ofertarAtraccion(reader, atraccion, file, archivo);
				if(!atraccionesAceptadas.isEmpty()) {
					for (Atraccion atrac : atraccionesAceptadas) {
						costoTotal += atrac.getCosto();
						duracionTotal += atrac.getDuracion();
					}
				}
			}
		}

		// Luego se ofertan aquellas promociones que no son de su preferencia siempre y
		// cuando disponga de tiempo y dinero
		for (Promocion promocion : promociones) {
			if (!promocion.getOfertada() && this.tieneTiempoYDinero(promocion.getDuracion(), promocion.getCosto())) {
				boolean puedeOfertar = true;

				// Se evalua si la atraccion tiene cupo y no fue ofertada anteriormente
				for (Atraccion atraccion : promocion.getAtracciones()) {
					if (atraccion.getOfertada() || !atraccion.tieneCupo()) {
						puedeOfertar = false;
						break;
					}
				}

				// Se oferta la promocion
				if (puedeOfertar) {
					promocionesAceptadas = ofertarPromocion(reader, promocion, file, archivo);
					if(!promocionesAceptadas.isEmpty()) {
						for (Promocion promo : promocionesAceptadas) {
							costoTotal += promo.getCosto();
							duracionTotal += promo.getDuracion();
						}
					}
				}
			}
		}

		// Por ultimo se ofertan las atracciones que no son de su preferencia siempre y
		// cuando disponga de tiempo y dinero
		for (Atraccion atraccion : atracciones) {
			if (!atraccion.getOfertada() && atraccion.tieneCupo()
					&& this.tieneTiempoYDinero(atraccion.getDuracion(), atraccion.getCosto())) {
				atraccionesAceptadas = ofertarAtraccion(reader, atraccion, file, archivo);
				if(!atraccionesAceptadas.isEmpty()) {
					for (Atraccion atrac : atraccionesAceptadas) {
						costoTotal += atrac.getCosto();
						duracionTotal += atrac.getDuracion();
					}
				}
			}
		}
		
		String[] finCliente = new String[2];
		if (costoTotal == 0 && duracionTotal == 0) {
			finCliente[0] = "No acepto ninguna sugerencia";
			finCliente[1] = "=(";
			archivo.agregarTextoEnArchivo(finCliente, file);
		}else {
			finCliente[0] = "Costo Total: " + costoTotal + " Monedas de Oro";
			finCliente[1] = "Duracion Total: " + duracionTotal + " Horas";
			archivo.agregarTextoEnArchivo(finCliente, file);
		}
	}

	private ArrayList<Promocion> ofertarPromocion(Scanner reader, Promocion promocion, FileWriter file, Archivo archivo){
		ArrayList<Promocion> promocionesAceptadas = new ArrayList<>();
		String decision;
		System.out.println("\n" + "PROMOCION");
		System.out.println("- " + promocion.getNombre());
		System.out.println("- Atracciones incluidas: " + promocion.imprimierAtracciones() );// + promocion.getAtracciones());
		System.out.println("- Duracion: " + promocion.getDuracion() + "hs");
		System.out.println("- Precio original: " + promocion.precioOriginal());
		System.out.println("- Precio con descuento: " + promocion.getCosto());
		System.out.println("- Monto ahorrado por promocion: " + promocion.descuentoObtenido());

		// Mientras no ingrese la letra indicada, volvera a preguntar
		do {
			System.out.println("Acepta la sugerencia? (S/N): ");
			decision = reader.nextLine();
		} while (!decision.toUpperCase().equals(Values.Aceptada) && !decision.toUpperCase().equals(Values.Rechazada));

		if (decision.toUpperCase().equals(Values.Aceptada)) {
			System.out.println("¡Aceptada!");
			archivo.agregarPromocionEnArchivo(promocion, file);

			promocionesAceptadas.add(promocion);
			for (Atraccion atraccion : promocion.getAtracciones()) {
				atraccion.setOfertada(true);
				atraccion.descontarCupo();
			}

			this.descontarDinero(promocion.getCosto());
			this.descontarTiempo(promocion.getDuracion());
		}

		promocion.setOfertada(true);

		return promocionesAceptadas;
	}

	@Override
	public String toString() {
		return "El Usuario " + nombre + ", cuenta con un presupuesto de " + dineroDisponible + " moneda/s de oro, y tiempo disponible de "
				+ tiempoDisponible  + " hs. Las atracciones de su preferencia son del tipo: " + preferencia + ".";
	}

	private ArrayList<Atraccion> ofertarAtraccion(Scanner reader, Atraccion atraccion, FileWriter file, Archivo archivo){
		ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<>();
		String decision;
		System.out.println("\n" + "ATRACCION");
		System.out.println("- " + atraccion.getTipo());
		System.out.println("- Nombre: " + atraccion.getNombre());
		System.out.println("- Precio: " + atraccion.getCosto());
		System.out.println("- Duracion: " + atraccion.getDuracion() + "hs");

		// Mientras no ingrese la letra indicada, volvera a preguntar
		do {
			System.out.println("Acepta la sugerencia? (S/N): ");
			decision = reader.nextLine();
		} while (!decision.toUpperCase().equals(Values.Aceptada) && !decision.toUpperCase().equals(Values.Rechazada));

		if (decision.toUpperCase().equals(Values.Aceptada)) {
			System.out.println("¡Aceptada!");
			archivo.agregarAtraccionEnArchivo(atraccion, file);

			atraccionesAceptadas.add(atraccion);
			this.descontarDinero(atraccion.getCosto());
			this.descontarTiempo(atraccion.getDuracion());
			atraccion.descontarCupo();
		}

		atraccion.setOfertada(true);
		
		return atraccionesAceptadas;
	}
}
