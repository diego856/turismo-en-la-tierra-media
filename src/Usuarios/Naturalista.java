package Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Atraccion;
import clases.Promocion;
import clases.Values;

public class Naturalista extends Usuario {
	
	public Naturalista(String nombre, double dineroDisponible, float tiempoDisponible) {
        this.preferencia = Values.Naturalista;
        this.dineroDisponible = dineroDisponible;
        this.tiempoDisponible = tiempoDisponible;
        this.nombre = nombre;
    }

	@Override
	public void recibirSugerencias(ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones) {
		Scanner reader = new Scanner(System.in);

		for (Promocion promocion : promociones) {
			if (promocion.getTipo().equals(this.preferencia) && this.tieneTiempo(promocion.getDuracion()) && this.tieneDinero(promocion.getCosto())) {
				boolean noOfertar = false;

				for (Atraccion atraccion : promocion.getAtracciones()) {
					if (atraccion.getOfertada() || !atraccion.tieneCupo()) {
						noOfertar = true;
						break;
					}
				}

				if (!noOfertar) {
					ofertarPromocion(reader, promocion);
				}
			}
		}

		for (Promocion promocion : promociones) {
			if (!promocion.getOfertada() && this.tieneTiempo(promocion.getDuracion()) && this.tieneDinero(promocion.getCosto())) {
				boolean noOfertar = false;

				for (Atraccion atraccion : promocion.getAtracciones()) {
					if (atraccion.getOfertada() || !atraccion.tieneCupo()) {
						noOfertar = true;
						break;
					}
				}

				if (!noOfertar) {
					ofertarPromocion(reader, promocion);
				}
			}
		}
		
		
		for (Atraccion atraccion : atracciones) {
			if(!atraccion.getOfertada() && atraccion.getTipo().equals(this.preferencia) && atraccion.tieneCupo() && this.tieneDinero(atraccion.getCosto()) && this.tieneTiempo(atraccion.getDuracion())) {
				ofertarAtraccion(reader, atraccion);
			}
		}
		
		for (Atraccion atraccion : atracciones) {
			if(!atraccion.getOfertada() && atraccion.tieneCupo() && this.tieneDinero(atraccion.getCosto()) && this.tieneTiempo(atraccion.getDuracion())) {
				ofertarAtraccion(reader, atraccion);
			}
		}

	}
	
}
