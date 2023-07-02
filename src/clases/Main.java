package clases;

import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Carga de Archivos
		Archivo archivo = new Archivo("atracciones");
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones();

		archivo.setNombre("promociones");
		ArrayList<Promocion> promociones = archivo.leerPromociones(atracciones);

		archivo.setNombre("perfiles-de-usuarios");
		ArrayList<Usuario> usuarios = archivo.leerPerfilesDeUsuarios();

		archivo.setNombre("itinerario-clientes");
		FileWriter file = archivo.crearArchivo();

		String[] inicioArchivo = new String[3];
		inicioArchivo[0] = Values.Separador;
		inicioArchivo[1] = Values.Separador;
		inicioArchivo[2] = "Itinerario de nuestros visitantes:";

		archivo.agregarTextoEnArchivo(inicioArchivo, file);

		// Ofrecer Sugerencias
		for (Usuario usuario : usuarios) {
			System.out.println("¡Bienvenido/a " + usuario.getNombre() + "!");
			System.out.println(usuario);
			System.out.println("\nA continuacion te realizaremos algunas sugerencias para tu estadía:");

			usuario.recibirSugerencias(atracciones, promociones, file, archivo);

			for (Atraccion atraccion : atracciones) {
				atraccion.setOfertada(false);
			}

			for (Promocion promocion : promociones) {
				promocion.setOfertada(false);
			}

			System.out.println("-------------------------");
			System.out.println("GRACIAS POR VISITARNOS!!");
			System.out.println("-------------------------\n");
		}

		String[] finArchivo = new String[2];
		finArchivo[0] = Values.Separador;
		finArchivo[1] = Values.Separador;
		archivo.agregarTextoEnArchivo(finArchivo, file);

		// Cierre de Archivo
		archivo.cerrarArchivo(file);
	}
}
