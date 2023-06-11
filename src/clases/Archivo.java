package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Archivo {
	private String nombre;

	// Constructor de Clase
	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	// Metodos de acceso (getters y setters)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Funciones de lectura de archivos
	public ArrayList<Usuario> leerPerfilesDeUsuarios() {
		Scanner lector = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try {
			lector = abrirArchivo();

			// Omitimos la linea de encabezados
			omitirLinea(lector);

			while (lector.hasNextLine()) {
				String nextLine = lector.nextLine();

				String[] perfilLeido = nextLine.split(",");

				String nombre = perfilLeido[0];
				String preferencias = perfilLeido[1];
				double dineroDisponible = Double.parseDouble(perfilLeido[2]);
				float tiempoDisponible = Float.parseFloat(perfilLeido[3]);

				Usuario usuario = new Usuario(nombre, preferencias, dineroDisponible, tiempoDisponible);
				usuarios.add(usuario);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			lector.close();
		}

		return usuarios;
	}

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

				String nombre = atraccionLeida[0];
				double costo = Double.parseDouble(atraccionLeida[1]);
				float duracion = Float.parseFloat(atraccionLeida[2]);
				int cupo = Integer.parseInt(atraccionLeida[3]);
				String tipo = atraccionLeida[4];

				Atraccion atraccion = new Atraccion(nombre, costo, duracion, cupo, tipo);

				atracciones.add(atraccion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			lector.close();
		}

		// Se ordena la coleccion segun las de mayor costo y duracion
		Collections.sort(atracciones, Archivo.getAtraccionComparador());

		return atracciones;
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
				float duracion = 0;

				String[] promocionLeida = nextLine.split(",");

				String nombre = promocionLeida[0];
				String tipo = promocionLeida[1];
				double costo = Double.parseDouble(promocionLeida[2]);

				String[] atraccion = promocionLeida[3].split(" - ");

				for (String nombreAtraccion : atraccion) {
					for (Atraccion atraccionDisponible : atraccionesDisponibles) {
						if (atraccionDisponible.getNombre().equals(nombreAtraccion)) {
							atracciones.add(atraccionDisponible);
							duracion += atraccionDisponible.getDuracion();
						}
					}
				}

				Promocion promocion = new Promocion(nombre, tipo, costo, atracciones, duracion);

				promociones.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			lector.close();
		}

		// Se ordena la coleccion segun las de mayor costo y duracion
		Collections.sort(promociones, Archivo.getPromocionComparador());

		return promociones;
	}

	// Funciones auxiliares
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

	// Comparadores
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

	// Funciones de grabado de archivos
	public void agregarTextoEnArchivo(String[] texto, FileWriter file) {
		PrintWriter printerWriter = null;

		try {
			printerWriter = new PrintWriter(file);
			for (int i = 0; i < texto.length; i++) {
				// Imprime los datos y hace un salto de linea
				printerWriter.println(texto[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agregarPromocionEnArchivo(Promocion promocion, FileWriter file) {
		PrintWriter printerWriter = null;

		try {
			printerWriter = new PrintWriter(file);
			printerWriter.println("Promocion:\n" + promocion.getNombre());
			printerWriter.print("Atracciones Incluidas: ");
			
			boolean primerLinea = true;
			
			printerWriter.print("[");
			for (Atraccion atraccion : promocion.getAtracciones()) {
				if (primerLinea){
					printerWriter.print(atraccion.getNombre());
					primerLinea = false;
				}else {
					printerWriter.print(", " + atraccion.getNombre());
				}
			}
			printerWriter.println("]");
			printerWriter.println("Tipo: " + promocion.getTipo());
			printerWriter.println("Costo: " + promocion.getCosto() + " Monedas de oro");
			printerWriter.println("Duracion: " + promocion.getDuracion() + " Horas" + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void agregarAtraccionEnArchivo(Atraccion atraccion, FileWriter file) {
		PrintWriter printerWriter = null;

		try {
			printerWriter = new PrintWriter(file);
			printerWriter.println("Atraccion:\n" + atraccion.getNombre());
			printerWriter.println("Tipo: " + atraccion.getTipo());
			printerWriter.println("Costo: " + atraccion.getCosto() + " Monedas de oro");
			printerWriter.println("Duracion: " + atraccion.getDuracion() + " Horas" + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FileWriter crearArchivo() {
		FileWriter file = null;

		try {
			file = new FileWriter("files/output/" + this.nombre + ".out");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file;
	}

	public void cerrarArchivo(FileWriter file) {
		if (file != null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
