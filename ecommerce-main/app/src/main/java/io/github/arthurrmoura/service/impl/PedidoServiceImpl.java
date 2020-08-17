package io.github.arthurrmoura.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.PedidoDAO;
import io.github.arthurrmoura.model.Pedido;
import io.github.arthurrmoura.service.spec.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	@Override
	public ArrayList<Pedido> listarPedidos(String statusEntrega) throws IOException {
		return pedidoDAO.listarPedidos(statusEntrega);
	}

	@Override
	public int inserirPedido(String idCliente, Pedido pedido) throws IOException {
		return pedidoDAO.inserirPedido(idCliente, pedido);
	}

}
