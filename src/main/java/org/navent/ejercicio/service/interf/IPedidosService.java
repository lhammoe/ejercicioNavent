package org.navent.ejercicio.service.interf;

import org.navent.ejercicio.domain.Pedido;

public interface IPedidosService {

	/**
	 * //inserta un nuevo pedido en la base de datos  
	 * (el pedido pasado como parámetro se completa con el nuevo id).
	 * 
	 * @param pedido
 	*/
	public void insert(Pedido pedido);
	
	/**
	 * Modifica un pedido existente
	 * @param pedido
	 */
	public void update(Pedido pedido);
	
	/**
	 * elimina el pedido que corresponde al id recibido.
	 * @param pedido
	 */
	public void delete(Pedido pedido);
	
	/**
	 *  busca un pedido por id.
	 * @param idPedido
	 * @return
	 */
	public Pedido select(Integer idPedido);
}
