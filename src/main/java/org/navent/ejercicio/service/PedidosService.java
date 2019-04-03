package org.navent.ejercicio.service;

import org.navent.ejercicio.domain.Pedido;
import org.navent.ejercicio.repository.interf.IPedidosDAO;
import org.navent.ejercicio.service.interf.IPedidosService;
import org.navent.ejercicio.util.BumexMemcached;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidosService implements IPedidosService{
	
	@Autowired
	private IPedidosDAO pedidosDao;

	/**
	 * Al consultar por un pedido concreto, lo mejor es que primero se acceda a la memcache y no a disco (BD) para 
	 * mejorar la performance de la aplicacion.
	 */
	public Pedido select(Integer idPedido) {
		//asumo que la key en la memcache es el id del pedido
		Pedido pedido = (Pedido) BumexMemcached.getInstance().get(idPedido.toString());
		if (pedido == null) {
			//si no está en la cache lo busco en la base
			pedido = pedidosDao.select(idPedido);
		}
		return pedido;
	}
	
	/**
	 * Todo los pedidos nuevos que se vayan realizando se deben almacenar en la memcache 
	 * con el fin de que luego el acceso a consultarlos sea más performante.
	 * 
	 */
	public void insert(Pedido pedido) {
		pedidosDao.insertOrUpdate(pedido);
		BumexMemcached.getInstance().set(pedido.getIdPedido().toString(), pedido);
	}
	
	/**
	 * En la actualización para evitar problemas de concurrencia, primero invalido el dato de la cache
	 * y luego actualizo la base de datos.  
	 * @param pedido
	 */
	public void update(Pedido pedido) {
		BumexMemcached.getInstance().delete(pedido.getIdPedido().toString());
		pedidosDao.insertOrUpdate(pedido);
		
	}

	@Override
	public void delete(Pedido pedido) {
		BumexMemcached.getInstance().delete(pedido.getIdPedido().toString());
		pedidosDao.delete(pedido);
	}
	
}
