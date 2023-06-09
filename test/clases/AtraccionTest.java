package clases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {
	private Atraccion viajeAMoria;
	private Atraccion viajeAErabor;

	@Before
	public void setUp() {
		viajeAMoria = new Atraccion("Moria", 10, 2, 6, "Aventura");
		viajeAErabor = new Atraccion("Erabor", 12, 3, 0, "Paisajes");
	}

	@Test
	public void revisarAtraccionConCupo() {
		boolean actual = viajeAMoria.tieneCupo();

		Assert.assertTrue(actual);
	}

	@Test
	public void revisarAtraccionSinCupo() {
		boolean actual = viajeAErabor.tieneCupo();

		Assert.assertFalse(actual);
	}

	@Test
	public void restarCupoAAtraccion() {
		viajeAMoria.descontarCupo();
		int esperado = 5;
		int actual = viajeAMoria.getCupo();

		Assert.assertEquals(esperado, actual);
	}

	@Test
	public void ofertarAtraccion() {
		boolean actual = viajeAMoria.getOfertada();
		Assert.assertFalse(actual);

		viajeAMoria.setOfertada(true);
		actual = viajeAMoria.getOfertada();
		Assert.assertTrue(actual);
	}

}
