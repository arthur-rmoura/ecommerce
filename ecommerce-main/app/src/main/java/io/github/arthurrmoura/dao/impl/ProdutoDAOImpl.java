package io.github.arthurrmoura.dao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.ProdutoDAO;
import io.github.arthurrmoura.dao.util.GenericDAO;
import io.github.arthurrmoura.model.Produto;
import io.github.arthurrmoura.model.ProdutoPedido;

@Service
public class ProdutoDAOImpl extends GenericDAO<Produto> implements ProdutoDAO {
	
	ProdutoDAOImpl(){
		super(Produto.class);
	}

	@Override
	@Transactional
	public void inserirAtualizarProduto(Produto produto) throws IOException {
		try {
			Produto p = super.findbyId(produto.getId());
			if(p!=null) super.update(produto);
			else {
				super.save(produto);
			}
		}
		catch (Exception ex) {
			throw new IOException("Não foi possível inserir o produto", ex);
		}
	}
	
	@Override
	@Transactional
	public void inserirListaProdutos(List<ProdutoPedido> produtosPedido) throws IOException {
		try {
			for(ProdutoPedido pp : produtosPedido) {
				inserirAtualizarProduto(pp.getProduto());
			}
		}
		catch (Exception ex) {
			throw new IOException("Não foi possível inserir o produto", ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Produto> listarProdutos() throws IOException {
		ArrayList<Produto> result = new ArrayList<Produto>();
		List<Object[]> temp = new ArrayList<Object[]>();
		String qry = "SELECT p.id, p.nome, p.valor, p.disponivel FROM Produto p ORDER BY p.nome ASC";
		Query query = null;
		try {
			query = entityManager.createQuery(qry);
			temp = query.getResultList();
			for (Object[] o : temp) {
				Produto p = new Produto();
				p.setId((UUID)o[0]);
				p.setNome((String) o[1]);
				p.setValor((BigDecimal)o[2]);
				p.setDisponivel((Boolean) o[3]);
				result.add(p);
			}
			
		} catch (Exception ex) {
			throw new IOException("Não foi possível recuperar a lista de produtos", ex);
		}
		return result;
	}
}
