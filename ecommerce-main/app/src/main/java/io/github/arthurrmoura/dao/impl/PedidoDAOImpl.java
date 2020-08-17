package io.github.arthurrmoura.dao.impl;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.ClienteDAO;
import io.github.arthurrmoura.dao.spec.PedidoDAO;
import io.github.arthurrmoura.dao.spec.ProdutoDAO;
import io.github.arthurrmoura.dao.util.GenericDAO;
import io.github.arthurrmoura.model.Cliente;
import io.github.arthurrmoura.model.Pedido;
import io.github.arthurrmoura.model.ProdutoPedido;

@Service
public class PedidoDAOImpl extends GenericDAO<Pedido> implements PedidoDAO {
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	@Autowired
	ClienteDAO clienteDAO;
	
	public PedidoDAOImpl() {
		super(Pedido.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Pedido> listarPedidos(String statusEntrega) throws IOException {
		ArrayList<Pedido> result = new ArrayList<Pedido>();
		List<Object[]> temp = new ArrayList<Object[]>();
		String qry = "SELECT p.id, p.idCliente, p.dataCadastro, p.statusEntrega FROM Pedido p WHERE p.statusEntrega = :statusEntrega ORDER BY p.dataCadastro ASC";
		Query query = null;
		try {
			query = entityManager.createQuery(qry);
			query.setParameter("statusEntrega", statusEntrega);
			temp = query.getResultList();
			for (Object[] o : temp) {
				Pedido p = new Pedido();
				p.setId((UUID)o[0]);
				p.setIdCliente((UUID) o[1]);
				p.setDataCadastro((OffsetDateTime)o[2]);
				p.setStatusEntrega((String) o[3]);
				result.add(p);
			}
			
			for(Pedido p : result) {
				qry = "SELECT pp FROM ProdutoPedido pp WHERE pp.pedido.id = :idPedido";
				query = entityManager.createQuery(qry);
				query.setParameter("idPedido", p.getId());
				List<ProdutoPedido> ppLista = query.getResultList();
				p.setProdutos(ppLista);
			}
		} catch (Exception ex) {
			throw new IOException("Não foi possível recuperar a lista de pedidos", ex);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Pedido> listarPedidosCliente(String idCliente) throws IOException {
		ArrayList<Pedido> result = new ArrayList<Pedido>();
		List<Object[]> temp = new ArrayList<Object[]>();
		String qry = "SELECT p.id, p.idCliente, p.dataCadastro, p.statusEntrega FROM Pedido p WHERE p.idCliente = :idCliente ORDER BY p.dataCadastro ASC";
		Query query = null;
		try {
			query = entityManager.createQuery(qry);
			query.setParameter("idCliente", UUID.fromString(idCliente));
			temp = query.getResultList();
			for (Object[] o : temp) {
				Pedido p = new Pedido();
				p.setId((UUID)o[0]);
				p.setIdCliente((UUID) o[1]);
				p.setDataCadastro((OffsetDateTime)o[2]);
				p.setStatusEntrega((String) o[3]);
				result.add(p);
			}
			
			for(Pedido p : result) {
				qry = "SELECT pp FROM ProdutoPedido pp WHERE pp.pedido.id = :idPedido";
				query = entityManager.createQuery(qry);
				query.setParameter("idPedido", p.getId());
				List<ProdutoPedido> ppLista = query.getResultList();
				p.setProdutos(ppLista);
			}
		} catch (Exception ex) {
			throw new IOException("Não foi possível recuperar a lista de pedidos do cliente", ex);
		}
		return result;
	}
	
	@Override
	@Transactional
	public int inserirPedido(String idCliente, Pedido pedido) throws IOException {
		try {
			Cliente c = clienteDAO.obterCliente(idCliente);
			if(c.getId()==null)return 2;
			Pedido p = super.findbyId(pedido.getId());
			if(p!=null) return 1;
			else {
				produtoDAO.inserirListaProdutos(pedido.getProdutos());
				super.save(pedido);
				return 0;
			}
		}
		catch (Exception ex) {
			throw new IOException("Não foi possível inserir o produto", ex);
		}
	}

}
