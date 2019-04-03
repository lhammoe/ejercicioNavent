package org.navent.ejercicio.repository.interf;

import org.navent.ejercicio.domain.Pedido;

public interface IPedidosDAO {

	/**
	 * //inserta un nuevo pedido en la base de datos o modifica un pedido existente 
	 * (en cado de crear uno nuevo, el pedido pasado como parámetro se completa con el nuevo id).
	 * 
	 * @param pedido
 	*/
	public void insertOrUpdate(Pedido pedido);
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
