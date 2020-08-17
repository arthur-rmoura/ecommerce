package io.github.arthurrmoura.service.spec;

import java.io.IOException;
import java.util.ArrayList;


import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;

public interface ClienteService {
	public Cliente obterCliente(String idCliente) throws IOException;
	public int inserirCliente(Cliente cliente) throws IOException;
	public ArrayList<Cliente> listarClientes(String ordem, String status) throws IOException;
	public int atualizarCliente(String idCliente, Cliente cliente) throws IOException;
	public ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException;
}
