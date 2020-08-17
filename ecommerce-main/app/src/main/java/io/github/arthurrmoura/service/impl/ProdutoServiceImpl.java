package io.github.arthurrmoura.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.dao.spec.ProdutoDAO;
import io.github.arthurrmoura.model.Produto;
import io.github.arthurrmoura.service.spec.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired
	ProdutoDAO produtoDAO;
	
	@Override
	public ArrayList<Produto> listarProdutos() throws IOException {
		return produtoDAO.listarProdutos();
	}

}
