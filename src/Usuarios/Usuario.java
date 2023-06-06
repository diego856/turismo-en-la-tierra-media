package Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Atraccion;
import clases.Promocion;
import clases.Values;

public abstract class Usuario {
    protected String preferencia;
    protected double dineroDisponible;
    protected float tiempoDisponible;
    protected String nombre;
    
    /*
    public Usuario() {
    	super();
    }
    
    public Usuario(String nombre, String preferencia,  double dineroDisponible, float tiempoDisponible) {
        this.preferencia = preferencia;
        this.dineroDisponible = dineroDisponible;
        this.tiempoDisponible = tiempoDisponible;
        this.nombre = nombre;
    }*/
    
    // Métodos de acceso (getters) para los atributos
    
    public String getPreferencia() {
        return preferencia;
    }
    
    public double getDineroDisponible() {
        return dineroDisponible;
    }
    
    public float getTiempoDisponible() {
        return tiempoDisponible;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    /*
    
    // Métodos de modificación (setters) para los atributos
    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
    
    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
    
    public void setTiempoDisponible(float tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/
    
    // Método de prueba
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Preferencia: " + preferencia);
        System.out.println("Dinero disponible: " + dineroDisponible);
        System.out.println("Tiempo disponible: " + tiempoDisponible);
    }
    
    protected boolean tieneTiempo(float duracion) {
    	return this.tiempoDisponible >= duracion;
    }
    
    protected boolean tieneDinero(double costo) {
    	return this.dineroDisponible >= costo;
    }
    
    
    protected void descontarTiempo(float tiempo) {
    	this.tiempoDisponible -= tiempo;
    }
    
    protected void descontarDinero(double dinero) {
    	this.dineroDisponible -= dinero;
    }

    protected void ofertarPromocion(Scanner reader, Promocion promocion) {
		String decision;
		System.out.println("PROMOCION");
		System.out.println("- Atracciones incluidas: " + promocion.getAtracciones());
		System.out.println("- Duracion: " + promocion.getDuracion() + "hs");
		System.out.println("- Precio con descuento: " + promocion.getCosto());

		do {
			System.out.println("Acepta la sugerencia? (S/N): ");
			decision = reader.nextLine();
		} while (!decision.toUpperCase().equals(Values.Aceptada) && !decision.toUpperCase().equals(Values.Rechazada));
		
		
		if (decision.toUpperCase().equals(Values.Aceptada)) { 
			for (Atraccion atraccion : promocion.getAtracciones()) {
				atraccion.setOfertada(true);
				atraccion.descontarCupo();
			}
			
			this.descontarDinero(promocion.getCosto());
			this.descontarTiempo(promocion.getDuracion());
		}
		
		promocion.setOfertada(true);
	}
    
    protected void ofertarAtraccion(Scanner reader, Atraccion atraccion) {
		String decision;
		System.out.println("ATRACCION");
		System.out.println("- Nombre: " + atraccion.getNombre());
		System.out.println("- Precio: $" + atraccion.getCosto());
		System.out.println("- Duracion: " + atraccion.getDuracion() + "hs");
		
		do {
			System.out.println("Acepta la sugerencia? (S/N): ");
			decision = reader.nextLine();
		} while (!decision.toUpperCase().equals(Values.Aceptada) && !decision.toUpperCase().equals(Values.Rechazada));
		
		if (decision.toUpperCase().equals(Values.Aceptada)) {
			this.descontarDinero(atraccion.getCosto());
			this.descontarTiempo(atraccion.getDuracion());
			atraccion.descontarCupo();
		}
		
		atraccion.setOfertada(true);
	}
    
    public abstract void recibirSugerencias(ArrayList<Atraccion> atracciones , ArrayList<Promocion> promociones);
}

