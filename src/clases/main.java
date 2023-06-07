package clases;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		Archivo archivo = new Archivo("atracciones");
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones();

		archivo.setNombre("promociones");
		ArrayList<Promocion> promociones = archivo.leerPromociones(atracciones);

		archivo.setNombre("perfiles-de-usuarios");
		ArrayList<Usuario> usuarios = archivo.leerPerfilesDeUsuarios();
		
		/*
		for (Promocion promocion : promociones) {
			System.out.println("--------------------------");
			System.out.println(promocion.getNombre());
			System.out.println("Costo: " + promocion.getCosto());
			System.out.println(promocion.getTipo());
			System.out.println("Duracion: " + promocion.getDuracion());
			System.out.println(promocion.getAtracciones());
			System.out.println("--------------------------");
		}
		
		
		for (Atraccion atraccion : atracciones) {
			System.out.println("--------------------------");
			System.out.println(atraccion.getNombre());
			System.out.println("Costo: " + atraccion.getCosto());
			System.out.println("Duracion: " + atraccion.getDuracion());
			System.out.println("Cupo: " + atraccion.getCupo());
			System.out.println("Tipo: " + atraccion.getTipo());
			System.out.println("--------------------------");
		}

		System.out.println("--------------------------");

		for (Usuario usuario : usuarios) {
			System.out.println("--------------------------");
			usuario.imprimirInformacion();
			// usuario.recibirSugerencias();
			System.out.println("--------------------------");
		}*/
		
		
		for (Usuario usuario : usuarios) {
			usuario.recibirSugerencias(atracciones, promociones);
			
			for (Atraccion atraccion : atracciones) {
				atraccion.setOfertada(false);
			}
			
			for (Promocion promocion : promociones) {
				promocion.setOfertada(false);
			}
			
			System.out.println("GRACIAS POR VISITARNOS!!");
			System.out.println("-------------------------");
		}

	}

}
