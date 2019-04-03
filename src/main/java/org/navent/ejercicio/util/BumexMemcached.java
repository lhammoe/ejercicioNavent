package org.navent.ejercicio.util;

/**
 * Desarrolle esta implementación practicamente vacía para implementar el singleton
 * y para poder utilizarla en el servicio a desarrollar
 * @author lhammoe@conicet.gov.ar
 *
 */
public class BumexMemcached {
	
	private static BumexMemcached bumexMemcached;
	
	private BumexMemcached() {
		
	}
	
	public static BumexMemcached getInstance() {
		if (bumexMemcached==null) {
			bumexMemcached = new BumexMemcached();
		}
		return bumexMemcached;
	}

	public void set(String key, Object value) {
		//Enunciado dice ya esta implementado
	}
	
	public Object get(String key) {
		//Enunciado dice ya esta implementado
		return null;
	}
	
	public void delete(String key) {
		//Enunciado dice ya esta implementado
	}
	
}
