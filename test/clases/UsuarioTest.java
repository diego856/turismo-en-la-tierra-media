package clases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario("Juan", 50, 100, "Preferencia1");
    }

    @Test
    public void testGetNombre() {
        Assert.assertEquals("Juan", usuario.getNombre());
        usuario.setNombre("Fran");
        Assert.assertEquals("Fran", usuario.getNombre());
    }

    @Test
    public void testGetPreferencia() {
    	Assert.assertEquals("Preferencia1", usuario.getPreferencia());
    	usuario.setPreferencia("Banquete");
    	Assert.assertEquals("Banquete", usuario.getPreferencia());
    }

    @Test
    public void testGetTiempoDisponible() {
    	Assert.assertEquals(50, usuario.getTiempoDisponible());
    }
    
    @Test
    public void testGetDineroDisponible() {
    	Assert.assertEquals(50, usuario.getDineroDisponible(), 0);
    }
}
