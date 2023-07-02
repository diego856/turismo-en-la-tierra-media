package clases;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PromocionTest {
	private Promocion promoAventura;
	private ArrayList<Atraccion> atraccionesDeLaPromo;

	@Before
	public void setUp() {
		atraccionesDeLaPromo = new ArrayList<Atraccion>();
		atraccionesDeLaPromo.add(new Atraccion("Moria", 10, 2, 6, "Aventura"));
		atraccionesDeLaPromo.add(new Atraccion("Erebor", 12, 3, 0, "Aventura"));
		promoAventura = new Promocion("Pack Aventura", "Aventura", 5.4, atraccionesDeLaPromo, 5);
	}

	@Test
	public void getNombre() {
		// Arrange
		String nombreEsperado = "Pack Aventura";
		String nombreActual = promoAventura.getNombre();

		// Assert
		Assert.assertEquals(nombreEsperado, nombreActual);
	}

	@Test
	public void getTipo() {
		// Arrange
		String tipoEsperado = "Aventura";
		String tipoActual = promoAventura.getTipo();

		// Assert
		Assert.assertEquals(tipoEsperado, tipoActual);
	}

	@Test
	public void getYSetCosto() {
		// Arrange
		promoAventura.setCosto(15);
		double costoEsperado = 15;
		double costoActual = promoAventura.getCosto();

		// Assert
		Assert.assertEquals(costoEsperado, costoActual, 0);
	}

	@Test
	public void getDuracion() {
		// Arrange
		float duracionEsperada = 5;
		float duracionActual = promoAventura.getDuracion();

		// Assert
		Assert.assertEquals(duracionEsperada, duracionActual, 0);
	}

	@Test
	public void getYSetOfertada() {
		// Arrange
		promoAventura.setOfertada(true);
		boolean ofertadaEsperado = true;
		boolean ofertadaActual = promoAventura.getOfertada();

		// Assert
		Assert.assertEquals(ofertadaEsperado, ofertadaActual);
	}

	@Test
	public void precioOriginal() {
		double actual = promoAventura.precioOriginal();
		double esperado = 22.0;

		Assert.assertEquals(esperado, actual, 0);
	}

	@Test
	public void imprimirAtracciones() {
		String actual = promoAventura.imprimirAtracciones();
		String esperado = "[Moria, Erebor]";

		Assert.assertEquals(esperado, actual);
	}

	@Test
	public void comparatorMayor() {
		// Arrange
		atraccionesDeLaPromo = new ArrayList<Atraccion>();
		atraccionesDeLaPromo.add(new Atraccion("Moria", 10, 2, 6, "Aventura"));
		atraccionesDeLaPromo.add(new Atraccion("Erebor", 12, 3, 0, "Aventura"));
		Promocion promoAventura2 = new Promocion("Pack Aventura2", "Aventura", 3.4, atraccionesDeLaPromo, 5);

		Comparator<Promocion> a = Promocion.getPromocionComparador();
		int result = a.compare(promoAventura2, promoAventura);

		// Assert
		Assert.assertTrue("Se espera que sea mayor", result == 1);
	}

	@Test
	public void comparatorMenor() {
		// Arrange
		atraccionesDeLaPromo = new ArrayList<Atraccion>();
		atraccionesDeLaPromo.add(new Atraccion("Moria", 10, 2, 6, "Aventura"));
		atraccionesDeLaPromo.add(new Atraccion("Erebor", 12, 3, 0, "Aventura"));
		Promocion promoAventura2 = new Promocion("Pack Aventura2", "Aventura", 3.4, atraccionesDeLaPromo, 5);

		Comparator<Promocion> a = Promocion.getPromocionComparador();
		int result = a.compare(promoAventura, promoAventura2);

		// Assert
		Assert.assertTrue("Se espera que sea menor", result == -1);
	}

	public void comparatorIgual() {
		// Arrange
		Comparator<Promocion> a = Promocion.getPromocionComparador();
		int result = a.compare(promoAventura, promoAventura);

		// Assert
		Assert.assertTrue("Se espera que sea igual", result == 0);
	}
}
