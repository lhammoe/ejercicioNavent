package org.navent.ejercicio.domain;

import java.math.BigDecimal;

public class Pedido {

	private Integer idPedido;
	private String nombre; 
	private BigDecimal monto;
	private BigDecimal descuento;
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public String getNombre() {
		return nombre;
	}
	public synchronized void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public synchronized void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public synchronized void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	
}
