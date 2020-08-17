package io.github.arthurrmoura.service.impl;


import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.ClienteDAO;
import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;
import io.github.arthurrmoura.service.spec.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public Cliente obterCliente(String id) throws IOException{
		return clienteDAO.obterCliente(id);
	}

	@Override
	public int inserirCliente(Cliente cliente) throws IOException {
		return clienteDAO.inserirCliente(cliente);
	}

	@Override
	public ArrayList<Cliente> listarClientes(String ordem, String status) throws IOException {
		return clienteDAO.listarClientes(ordem,status);
	}

	@Override
	public int atualizarCliente(String idCliente, Cliente cliente) throws IOException {
		return clienteDAO.atualizarCliente(idCliente, cliente);
	}

	@Override
	public ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException {
		return clienteDAO.listarPedidosCliente(idCliente);
	}

}
