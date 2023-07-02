package clases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	private Usuario usuario;

	@Before
	public void setUp() {
		usuario = new Usuario("Juan", "Preferencia1", 100, 50);
	}

	@Test
	public void getNombre() {
		// Arrange
		String nombreEsperado = "Juan";
		String nombreActual = usuario.getNombre();

		// Assert
		Assert.assertEquals(nombreEsperado, nombreActual);
	}

	@Test
	public void getPreferencia() {
		// Arrange
		String preferenciaEsperado = "Preferencia1";
		String preferenciaActual = usuario.getPreferencia();

		// Assert
		Assert.assertEquals(preferenciaEsperado, preferenciaActual);
	}

	@Test
	public void getTiempoDisponible() {
		// Arrange
		float tiempoEsperado = 50;
		float tiempoActual = usuario.getTiempoDisponible();

		// Assert
		Assert.assertEquals(tiempoEsperado, tiempoActual, 0);
	}

	@Test
	public void getDineroDisponible() {
		// Arrange
		double dineroEsperado = 100;
		double dineroActual = usuario.getDineroDisponible();

		// Assert
		Assert.assertEquals(dineroEsperado, dineroActual, 0);
	}
}
