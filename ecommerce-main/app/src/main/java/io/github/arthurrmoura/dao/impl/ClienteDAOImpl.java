package io.github.arthurrmoura.dao.impl;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.ClienteDAO;
import io.github.arthurrmoura.dao.spec.PedidoDAO;
import io.github.arthurrmoura.dao.util.GenericDAO;
import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;

@Service
public class ClienteDAOImpl extends GenericDAO<Cliente> implements ClienteDAO {
	
	@Autowired
	PedidoDAO pedidoDAO;
	
	public ClienteDAOImpl() {
		super(Cliente.class);
	}
	
	@Override
	public Cliente obterCliente(String id) {
		UUID idUUID = UUID.fromString(id);
		Cliente cliente = super.findbyId(idUUID);
		if(cliente!=null)return cliente;
		else {
			return new Cliente();
		}
	}

	@Override
	@Transactional
	public int inserirCliente(Cliente cliente) throws IOException {
		try {
			Cliente c = super.findbyId(cliente.getId());
			if(c!=null) return 1;
			else {
				super.update(cliente);
				return 0;
			}
		}
		catch (Exception ex) {
			throw new IOException("Não foi possível inserir o cliente", ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Cliente> listarClientes(String ordem, String status) throws IOException {
		
		if(ordem.regionMatches(0, "data", 0, 4))ordem="c.dataCadastro";
		else ordem= "c." + ordem;
		ArrayList<Cliente> result = new ArrayList<Cliente>();
		List<Object[]> temp = new ArrayList<Object[]>();
		String qry = "SELECT c.id, c.nome, c.dataCadastro, c.status FROM Cliente c WHERE c.status = :status ORDER BY ";
		qry+=ordem+" ASC";
		Query query = null;
		try {
			query = entityManager.createQuery(qry);
			query.setParameter("status", status);
			temp = query.getResultList();
			for (Object[] o : temp) {
				Cliente c = new Cliente();
				c.setId((UUID)o[0]);
				c.setNome((String) o[1]);
				c.setDataCadastro((LocalDate)o[2]);
				c.setStatus((String) o[3]);
				
				result.add(c);
			}
		} catch (Exception ex) {
			throw new IOException("Não foi possível recuperar a lista de clientes", ex);
		}
		return result;
	}

	@Override
	@Transactional
	public int atualizarCliente(String idCliente, Cliente cliente) throws IOException {
		try {
			Cliente c = super.findbyId(UUID.fromString(idCliente));
			if(c==null) return 1;
			else if(UUID.fromString(idCliente).equals(cliente.getId())){
				super.update(cliente);
				return 0;
			}
			else if(super.findbyId(cliente.getId()) == null){
				super.delete(c);
				super.update(cliente);
				return 0;
			}
			else return 2;
		}
		catch (Exception ex) {
			throw new IOException("Não foi possível atualizar o cliente", ex);
		}
	}

	@Override
	public ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException {
		Cliente c = super.findbyId(UUID.fromString(idCliente));
		if(c==null) return new ArrayList<Pedido>();
		return pedidoDAO.listarPedidosCliente(idCliente);
	}
	

}
