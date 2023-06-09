package clases;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PromocionTest {
	private Promocion promocionTest;
	private Atraccion atraccionTest;
	
	private Promocion promoAventura;
	private ArrayList<Atraccion> atraccionesDeLaPromo;

	@Before
	public void setUp() {
		atraccionTest = new Atraccion("promoTest", (double) 1, (float) 0.5, 10, "Aventura");
		ArrayList<Atraccion> atraccionesTest = new ArrayList<>();
		atraccionesTest.add(atraccionTest);
		promocionTest = new Promocion("promoTest", "Aventura", (double) 1, atraccionesTest, (float) 0.5);
		
		atraccionesDeLaPromo = new ArrayList<Atraccion>();
		atraccionesDeLaPromo.add(new Atraccion("Moria", 10, 2, 6, "Aventura"));
		atraccionesDeLaPromo.add(new Atraccion("Erabor", 12, 3, 0, "Aventura"));
		promoAventura = new Promocion("Pack Aventura", "Aventura", 5.4, atraccionesDeLaPromo, 5);
	
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
	
	@Test
	public void precioOriginalDeLaPromocion() {
		double actual = promoAventura.precioOriginal();
		double esperado = 22.0;
		
		Assert.assertEquals(esperado, actual, 0);
	}
	
	@Test
	public void descuentoAhorradoPorPromocion() {
		double actual = promoAventura.descuentoObtenido();
		double esperado = 16.6;
		
		Assert.assertEquals(esperado, actual, 0);
	}
	
}
