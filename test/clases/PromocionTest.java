package clases;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class PromocionTest {

	@Test
	public void setAndGetNombre() {
		// Arrange
		Promocion promocion = new Promocion();
		String nombreTest = "nombreTest";

		// Act
		promocion.setNombre(nombreTest);

		// Assert
		Assert.assertEquals(nombreTest, promocion.getNombre());
	}

	@Test
	public void setAndGetTipo() {
		// Arrange
		Promocion promocion = new Promocion();
		String nombreTipo = "nombreTipo";

		// Act
		promocion.setTipo(nombreTipo);

		// Assert
		Assert.assertEquals(nombreTipo, promocion.getTipo());
	}
	
	@Test
	public void setAndGetCosto() {
		// Arrange
		Promocion promocion = new Promocion();
		double costo = 15.5;
		boolean testPassed = false;

		// Act
		promocion.setCosto(costo);

		// Assert
		if (costo == promocion.getCosto()){
			testPassed = true;
		}
		
		Assert.assertEquals(testPassed, true);
	}
	
	@Test
	// TODO: hacer test de atracciones cuando la clase atracciones este terminada
	public void setAndGetAtracciones() {
		// Arrange
		

		// Act
		

		// Assert
		
	}
}
