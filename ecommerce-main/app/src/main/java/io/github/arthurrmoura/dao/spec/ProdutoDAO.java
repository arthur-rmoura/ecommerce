package io.github.arthurrmoura.dao.spec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.arthurrmoura.model.Produto;
import io.github.arthurrmoura.model.ProdutoPedido;

public interface ProdutoDAO {
	
	public void inserirAtualizarProduto(Produto produto) throws IOException;

	public void inserirListaProdutos(List<ProdutoPedido> produtos) throws IOException;

	public ArrayList<Produto> listarProdutos() throws IOException;
}
