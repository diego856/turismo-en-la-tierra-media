package clases;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PromocionTest {
	private Promocion promocionTest;
	private Atraccion atraccionTest;

	@Before
	public void setUp() {
		atraccionTest = new Atraccion("promoTest", (double) 1, (float) 0.5, 10, "Aventura");
		ArrayList<Atraccion> atraccionesTest = new ArrayList<>();
		atraccionesTest.add(atraccionTest);
		promocionTest = new Promocion("promoTest", "Aventura", (double) 1, atraccionesTest, (float) 0.5);
	}

	@Test
	public void GetNombre() {
		// Arrange
		String nombrePromo = "promoTest";
		
		System.out.println(promocionTest.getAtracciones());

		// Assert
		Assert.assertEquals(nombrePromo, promocionTest.getNombre());
	}

	@Test
	public void GetTipo() {
		// Arrange
		String nombreTipo = "Aventura";

		// Assert
		Assert.assertEquals(nombreTipo, promocionTest.getTipo());
	}

	@Test
	public void GetCosto() {
		// Arrange
		double costo = 1;

		// Assert
		Assert.assertEquals(costo, promocionTest.getCosto(), 0);
	}
}
