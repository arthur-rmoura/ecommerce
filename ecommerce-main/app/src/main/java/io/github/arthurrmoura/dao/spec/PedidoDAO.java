package io.github.arthurrmoura.dao.spec;

import java.io.IOException;
import java.util.ArrayList;

import io.github.arthurrmoura.model.Pedido;

public interface PedidoDAO {

	ArrayList<Pedido> listarPedidos(String statusEntrega) throws IOException;
	
	int inserirPedido(String idCliente, Pedido pedido) throws IOException;

	ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException;
	
}
