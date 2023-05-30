package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	// TODO: Descomentar cuando este terminada la clase Usuario
	/*
	 * public ArrayList<Usuario> leerPerfilesDeUsuarios() { Scanner lector = null;
	 * ArrayList<Usuario> usuarios = new ArrayList<>(); try { lector =
	 * abrirArchivo();
	 * 
	 * // Omitimos la linea de encabezados omitirLinea(lector);
	 * 
	 * while (lector.hasNextLine()) { String nextLine = lector.nextLine();
	 * 
	 * String[] perfilLeido = nextLine.split(",");
	 * 
	 * Usuario usuario = new Usuario(); usuario.setNombre(perfilLeido[0]);
	 * usuario.setPreferencias(perfilLeido[1]);
	 * usuario.setDineroDisponible(Double.parseDouble(perfilLeido[2]));
	 * usuario.setTiempoDisponible(Float.parseFloat(perfilLeido[3]));
	 * 
	 * usuarios.add(usuario); } } catch (FileNotFoundException e) {
	 * e.printStackTrace(); } finally { lector.close(); }
	 * 
	 * return usuarios; }
	 */

	public ArrayList<Atraccion> leerAtracciones() {
		Scanner lector = null;
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		try {
			lector = abrirArchivo();

			// Omitimos la linea de encabezados
			omitirLinea(lector);

			while (lector.hasNextLine()) {
				String nextLine = lector.nextLine();

				String[] atraccionLeida = nextLine.split(",");

				Atraccion atraccion = new Atraccion();
				atraccion.setNombre(atraccionLeida[0]);
				atraccion.setCosto(Double.parseDouble(atraccionLeida[1]));
				atraccion.setDuracion(Float.parseFloat(atraccionLeida[2]));
				atraccion.setCupo(Integer.parseInt(atraccionLeida[3]));
				atraccion.setTipo(atraccionLeida[4]);

				atracciones.add(atraccion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			lector.close();
		}

		return atracciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Promocion> leerPromociones(ArrayList<Atraccion> atraccionesDisponibles) {
		Scanner lector = null;
		ArrayList<Promocion> promociones = new ArrayList<>();
		try {
			lector = abrirArchivo();

			// Omitimos la linea de encabezados
			omitirLinea(lector);

			while (lector.hasNextLine()) {
				ArrayList<Atraccion> atracciones = new ArrayList<>();
				String nextLine = lector.nextLine();

				String[] promocionLeida = nextLine.split(",");

				Promocion promocion = new Promocion();
				promocion.setNombre(promocionLeida[0]);
				promocion.setTipo(promocionLeida[1]);
				promocion.setCosto(Double.parseDouble(promocionLeida[2]));

				String[] atraccion = promocionLeida[3].split(" - ");

				for (String nombreAtraccion : atraccion) {
					for (Atraccion atraccionDisponible : atraccionesDisponibles) {
						if (atraccionDisponible.getNombre().equals(nombreAtraccion)) {
							atracciones.add(atraccionDisponible);
						}
					}
				}

				promocion.setAtracciones(atracciones);

				promociones.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			lector.close();
		}

		return promociones;
	}

	private void omitirLinea(Scanner reader) {
		if (reader.hasNext() == true) {
			reader.nextLine();
		}
	}

	private Scanner abrirArchivo() throws FileNotFoundException {
		Scanner reader;
		File file = new File("files/input/" + this.nombre + ".csv");
		reader = new Scanner(file);
		return reader;
	}
}
