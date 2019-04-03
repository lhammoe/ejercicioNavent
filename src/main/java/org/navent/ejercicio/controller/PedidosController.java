package org.navent.ejercicio.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.navent.ejercicio.domain.Pedido;
import org.navent.ejercicio.service.interf.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	IPedidosService pedidosService;
	
	/**
	 * https://www.baeldung.com/spring-request-response-body
	 * Este link explica las annotations @ResponseBody y @RequestBody, basicamente la primera serializa un objeto a json
	 * y la segunda deserializa de json a un objeto 
	 * @param object
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/grabar", method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> registarPedidos(@RequestBody Pedido object,HttpServletRequest request) {
		pedidosService.insert(object);
		return null;//para que compile
	}

}
