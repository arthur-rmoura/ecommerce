package io.github.arthurrmoura.service.spec;

import java.io.IOException;
import java.util.ArrayList;

import io.github.arthurrmoura.model.Pedido;

public interface PedidoService {

	ArrayList<Pedido> listarPedidos(String statusEntrega) throws IOException;

	int inserirPedido(String idCliente, Pedido pedido) throws IOException;;

}
