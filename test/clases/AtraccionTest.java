package clases;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {
	private Atraccion viajeMoria;
	private Atraccion viajeErebor;

	@Before
	public void setUp() {
		viajeMoria = new Atraccion("Moria", 10, 2, 6, "Aventura");
		viajeErebor = new Atraccion("Erebor", 12, 3, 0, "Paisajes");
	}

	@Test
	public void getNombre() {
		// Arrange
		String esperadoMoria = "Moria";
		String actualMoria = viajeMoria.getNombre();

		String esperadoErebor = "Erebor";
		String actualErebor = viajeErebor.getNombre();

		// actualMoria
		Assert.assertEquals(esperadoMoria, actualMoria);
		Assert.assertEquals(esperadoErebor, actualErebor);
	}

	@Test
	public void getCosto() {
		// Arrange
		double esperadoMoria = 10;
		double actualMoria = viajeMoria.getCosto();

		double esperadoErebor = 12;
		double actualErebor = viajeErebor.getCosto();

		// Assert
		Assert.assertEquals(esperadoMoria, actualMoria, 0);
		Assert.assertEquals(esperadoErebor, actualErebor, 0);
	}

	@Test
	public void getDuracion() {
		// Arrange
		float esperadoMoria = 2;
		float actualMoria = viajeMoria.getDuracion();

		float esperadoErebor = 3;
		float actualErebor = viajeErebor.getDuracion();

		// Assert
		Assert.assertEquals(esperadoMoria, actualMoria, 0);
		Assert.assertEquals(esperadoErebor, actualErebor, 0);
	}

	@Test
	public void getCupo() {
		// Arrange
		int esperadoMoria = 6;
		int actualMoria = viajeMoria.getCupo();

		int esperadoErebor = 0;
		int actualErebor = viajeErebor.getCupo();

		// Assert
		Assert.assertEquals(esperadoMoria, actualMoria, 0);
		Assert.assertEquals(esperadoErebor, actualErebor, 0);
	}

	@Test
	public void getTipo() {
		// Arrange
		String esperadoMoria = "Aventura";
		String actualMoria = viajeMoria.getTipo();

		String esperadoErebor = "Paisajes";
		String actualErebor = viajeErebor.getTipo();

		// Assert
		Assert.assertEquals(esperadoMoria, actualMoria);
		Assert.assertEquals(esperadoErebor, actualErebor);
	}

	@Test
	public void getYSetOfertada() {
		// Arrange
		viajeMoria.setOfertada(false);
		viajeErebor.setOfertada(true);

		// Assert
		Assert.assertEquals(false, viajeMoria.getOfertada());
		Assert.assertEquals(true, viajeErebor.getOfertada());
	}

	@Test
	public void tieneCupo() {
		// Arrange
		boolean esperadoMoria = true;
		boolean actualMoria = viajeMoria.tieneCupo();

		boolean esperadoErebor = false;
		boolean actualErebor = viajeErebor.tieneCupo();

		// Assert
		Assert.assertEquals(esperadoMoria, actualMoria);
		Assert.assertEquals(esperadoErebor, actualErebor);
	}

	@Test
	public void descontarCupo() {
		// Arrange
		viajeMoria.descontarCupo();

		// Assert
		Assert.assertEquals(5, viajeMoria.getCupo(), 0);
	}

	@Test
	public void comparatorMayor() {
		// Arrange
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(viajeMoria);
		atracciones.add(viajeErebor);

		Comparator<Atraccion> a = Atraccion.getAtraccionComparador();
		int result = a.compare(viajeMoria, viajeErebor);

		// Assert
		Assert.assertTrue("Se espera que sea mayor", result == 1);
	}

	@Test
	public void comparatorMenor() {
		// Arrange
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(viajeMoria);
		atracciones.add(viajeErebor);

		Comparator<Atraccion> a = Atraccion.getAtraccionComparador();
		int result = a.compare(viajeErebor, viajeMoria);

		// Assert
		Assert.assertTrue("Se espera que sea menor", result == -1);
	}

	public void comparatorIgual() {
		// Arrange
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(viajeMoria);
		atracciones.add(viajeMoria);

		Comparator<Atraccion> a = Atraccion.getAtraccionComparador();
		int result = a.compare(viajeMoria, viajeMoria);

		// Assert
		Assert.assertTrue("Se espera que sea igual", result == 0);
	}

}
