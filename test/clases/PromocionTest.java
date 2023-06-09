package clases;

import java.util.ArrayList;

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
		atraccionesDeLaPromo.add(new Atraccion("Erabor", 12, 3, 0, "Aventura"));
		promoAventura = new Promocion("Pack Aventura", "Aventura", 5.4, atraccionesDeLaPromo, 5);
	
}

	@Test
	public void GetNombre() {
		// Arrange
		String nombreEsperado = "Pack Aventura";
		String nombreActual = promoAventura.getNombre();

		// Assert
		Assert.assertEquals(nombreEsperado, nombreActual);
	}

	@Test
	public void GetTipo() {
		// Arrange
		String tipoEsperado = "Aventura";
		String tipoActual = promoAventura.getTipo();

		// Assert
		Assert.assertEquals(tipoEsperado, tipoActual);
	}

	@Test
	public void GetCosto() {
		// Arrange
		double costoEsperado = 5.4;
		double costoActual = promoAventura.getCosto();

		// Assert
		Assert.assertEquals(costoEsperado, costoActual, 0);
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
