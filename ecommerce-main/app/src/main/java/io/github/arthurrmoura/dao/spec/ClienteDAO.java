package io.github.arthurrmoura.dao.spec;

import java.io.IOException;
import java.util.ArrayList;

import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;

public interface ClienteDAO {

	Cliente obterCliente(String id);

	int inserirCliente(Cliente cliente) throws IOException;

	ArrayList<Cliente> listarClientes(String ordem, String status) throws IOException;

	int atualizarCliente(String idCliente, Cliente cliente) throws IOException;

	ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException;

}
