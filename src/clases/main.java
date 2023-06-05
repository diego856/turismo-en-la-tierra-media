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

		for (Promocion promocion : promociones) {
			System.out.println("--------------------------");
			System.out.println(promocion.getNombre());
			System.out.println(promocion.getCosto());
			System.out.println(promocion.getTipo());
			System.out.println(promocion.getAtracciones());
			System.out.println("--------------------------");
		}
		
		System.out.println("--------------------------");
		
		for (Usuario usuario : usuarios) {
			System.out.println("--------------------------");
			usuario.imprimirInformacion();
			System.out.println("--------------------------");
		}
		
	}

}
