package clases;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {
	
	public static List<Atraccion> leerArchivoAtraccion(String rutaArchivo) {
		Scanner sc = null;
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		try {
			sc = new Scanner(new File(rutaArchivo));
			Atraccion atraccion;
			sc.nextLine();
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String nombreAtraccion = linea.split(",")[0];
				double costoAtraccion = Double.parseDouble(linea.split(",")[1]);
				float duracionAtraccion = Float.parseFloat(linea.split(",")[2]);
				int cupoAtraccion = Integer.parseInt(linea.split(",")[3]);
				String tipoAtraccion = linea.split(",")[4];

				try {
					atraccion = new Atraccion(nombreAtraccion, costoAtraccion, duracionAtraccion, cupoAtraccion,
							tipoAtraccion);
					atracciones.add(atraccion);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return atracciones;
	}
	
	
	private List<Atraccion> atracciones;
	
	@Before
	public void setUp() {
		atracciones = leerArchivoAtraccion("files//input//atracciones.csv");
	}
	
	@Test
	public void imprimirListaAtracciones() {
		for (Atraccion atraccion : atracciones) {
			System.out.println(atraccion);
		}
	}
	
}
