package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {
	@Test
	public void getYSetNombre() {
		Archivo archivo = new Archivo("archivo");
		archivo.setNombre("archivoTest");
		Assert.assertEquals("archivoTest", archivo.getNombre());
	}

	@Test
	public void lecturaYEscrituraArchivoAtracciones() {
		// Carga de Atracciones
		Archivo archivo = new Archivo("atracciones");
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones();

		// Graba las atracciones en el archivo de Test
		archivo.setNombre("atraccionesTest");
		FileWriter file = archivo.crearArchivo();

		for (Atraccion atraccion : atracciones) {
			archivo.agregarAtraccionEnArchivo(atraccion, file);
		}

		archivo.cerrarArchivo(file);

		// Contempla comparar cualquier cantidad de atracciones
		// Es estricto a que sea exactamente igual
		try {
			byte[] f1 = Files.readAllBytes(Paths.get("files/output/out-esperado/atraccionesTest.out"));
			byte[] f2 = Files.readAllBytes(Paths.get("files/output/atraccionesTest.out"));
			Assert.assertArrayEquals(f1, f2);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void lecturaYEscrituraArchivoPromociones() {
		// Carga de Atracciones
		Archivo archivo = new Archivo("atracciones");
		ArrayList<Atraccion> atracciones = archivo.leerAtracciones();

		// Carga de Promociones
		archivo.setNombre("promociones");
		ArrayList<Promocion> promociones = archivo.leerPromociones(atracciones);

		// Graba las promociones en el archivo de Test
		archivo.setNombre("promocionesTest");
		FileWriter file = archivo.crearArchivo();

		for (Promocion promocion : promociones) {
			archivo.agregarPromocionEnArchivo(promocion, file);
		}

		archivo.cerrarArchivo(file);

		// Contempla comparar cualquier cantidad de promociones
		// Es estricto a que sea exactamente igual
		try {
			byte[] f1 = Files.readAllBytes(Paths.get("files/output/out-esperado/promocionesTest.out"));
			byte[] f2 = Files.readAllBytes(Paths.get("files/output/promocionesTest.out"));
			Assert.assertArrayEquals(f1, f2);

		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void lecturaArchivoPerfilesDeUsuariosYEscrituraDeArchivoTexto() {
		// Carga de Perfiles de Usuarios
		Archivo archivo = new Archivo("perfiles-de-usuarios");
		ArrayList<Usuario> usuarios = archivo.leerPerfilesDeUsuarios();

		// Graba los usuarios en el archivo de Test
		archivo.setNombre("usuariosTest");
		FileWriter file = archivo.crearArchivo();

		for (Usuario usuario : usuarios) {
			String[] perfilLeido = new String[4];

			perfilLeido[0] = usuario.getNombre();
			perfilLeido[1] = usuario.getPreferencia();
			perfilLeido[2] = Double.toString(usuario.getDineroDisponible());
			perfilLeido[3] = Float.toString(usuario.getTiempoDisponible());

			archivo.agregarTextoEnArchivo(perfilLeido, file);
		}

		archivo.cerrarArchivo(file);

		// Contempla comparar cualquier cantidad de Usuarios
		// Es estricto a que sea exactamente igual
		try {
			byte[] f1 = Files.readAllBytes(Paths.get("files/output/out-esperado/usuariosTest.out"));
			byte[] f2 = Files.readAllBytes(Paths.get("files/output/usuariosTest.out"));
			Assert.assertArrayEquals(f1, f2);

		} catch (IOException e) {
			Assert.fail();
		}
	}
}