package io.github.arthurrmoura.api.impl;

import io.github.arthurrmoura.api.spec.ClientesApiDelegate;
import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;
import io.github.arthurrmoura.model.Retorno;
import io.github.arthurrmoura.service.spec.ClienteService;
import io.github.arthurrmoura.service.spec.PedidoService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientesApiDelegateImpl implements ClientesApiDelegate {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Override
    public ResponseEntity<Cliente> obterCliente(String idCliente) {
    	Cliente cliente;
		try {
			cliente = clienteService.obterCliente(idCliente);
			if(cliente.getId()!=null)
	    		return ResponseEntity.ok(cliente);
	    	else {
	    		ResponseEntity<Cliente> re = new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	    		return re;
	    	}
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity<Cliente> re = new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
			return re;		
		}
    }
	
	@Override
	public ResponseEntity<Retorno> inserirCliente(Cliente cliente){
		Retorno rt = new Retorno();
		if(cliente.getDataCadastro().isAfter(LocalDate.now())) {
			rt.setMensagem("Data de cadastro inválida");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		int resultado;
		try {
			resultado = clienteService.inserirCliente(cliente);
		} catch (IOException e) {
			e.printStackTrace();
			rt.setMensagem("Erro ao adicionar o cliente");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
		if(resultado == 0) {
			rt.setMensagem("Cliente adicionado com sucesso");
			rt.setSucesso(true);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.CREATED);
    		return re;
		}
		else if(resultado == 1) {
			rt.setMensagem("Cliente já inserido");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		else {
			rt.setMensagem("Erro ao adicionar o cliente");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
	
	@Override
	public ResponseEntity<Retorno> atualizarCliente(String idCliente, Cliente cliente){
		Retorno rt = new Retorno();
		if(cliente.getDataCadastro().isAfter(LocalDate.now())) {
			rt.setMensagem("Data de cadastro inválida");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		int resultado;
		try {
			resultado = clienteService.atualizarCliente(idCliente, cliente);
		} catch (IOException e) {
			e.printStackTrace();
			rt.setMensagem("Erro ao atualizar o cliente");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
		if(resultado == 0) {
			rt.setMensagem("Cliente atualizado com sucesso");
			rt.setSucesso(true);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.OK);
    		return re;
		}
		else if(resultado == 1) {
			rt.setMensagem("Cliente não econtrado");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		else if(resultado == 2) {
			rt.setMensagem("Impossível atualizar o cliente, parâmetros inválidos");
			rt.setDescricao("Id passado no json da payload da requisição já existe na base de dados");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		else {
			rt.setMensagem("Erro ao atualizar o cliente");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
	
	@Override
	public ResponseEntity<List<Cliente>> listarClientes(String ordem, String status) {
		try {
			ArrayList<Cliente> clientes;
			List<String> colunas = new ArrayList<String>();
			colunas.add("id"); colunas.add("nome"); colunas.add("datacadastro"); colunas.add("status"); colunas.add("dataCadastro"); colunas.add("data-cadastro");
			if(ordem != null && colunas.contains(ordem)) {
				clientes = clienteService.listarClientes(ordem, status);
				if(!clientes.isEmpty())
		    		return ResponseEntity.ok(clientes);
		    	else {
		    		ResponseEntity<List<Cliente>> re = new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(), HttpStatus.NO_CONTENT);
		    		return re;
		    	}
			}
			else {
				ResponseEntity<List<Cliente>> re = new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(), HttpStatus.BAD_REQUEST);
	    		return re;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity<List<Cliente>> re = new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(),HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
	
	@Override
	public ResponseEntity<Retorno> inserirPedido(String idCliente, Pedido pedido) {
		Retorno rt = new Retorno();
		if(pedido.getDataCadastro().isAfter(OffsetDateTime.now())) {
			rt.setMensagem("Data de cadastro inválida");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		int resultado;
		try {
			resultado = pedidoService.inserirPedido(idCliente, pedido);
		} catch (IOException e) {
			e.printStackTrace();
			rt.setMensagem("Erro ao adicionar ao pedido");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
		if(resultado == 0) {
			rt.setMensagem("Pedido adicionado com sucesso");
			rt.setSucesso(true);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.CREATED);
    		return re;
		}
		else if(resultado == 1) {
			rt.setMensagem("Pedido já inserido");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		else if(resultado == 2) {
			rt.setMensagem("Cliente informado não existe");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.BAD_REQUEST);
    		return re;
		}
		else {
			rt.setMensagem("Erro ao adicionar ao pedido");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt,HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
	
	@Override
	public ResponseEntity<List<Pedido>> listarPedidosCliente(String idCliente) {
		try {
			List<Pedido> listaPedidos =  clienteService.listarPedidosCliente(idCliente);
			if(!listaPedidos.isEmpty())
	    		return ResponseEntity.ok(listaPedidos);
	    	else {
	    		ResponseEntity<List<Pedido>> re = new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(), HttpStatus.NO_CONTENT);
	    		return re;
	    	}
			
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity<List<Pedido>> re = new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(),HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
}
