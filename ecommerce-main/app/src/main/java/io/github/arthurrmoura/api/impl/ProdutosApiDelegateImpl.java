package io.github.arthurrmoura.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.api.spec.ProdutosApiDelegate;
import io.github.arthurrmoura.model.Produto;
import io.github.arthurrmoura.service.spec.ProdutoService;

@Service
public class ProdutosApiDelegateImpl implements ProdutosApiDelegate{
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public ResponseEntity<List<Produto>> listarProdutos() {
		try {
			ArrayList<Produto> produtos;
			produtos = produtoService.listarProdutos();
			if(!produtos.isEmpty())
	    		return ResponseEntity.ok(produtos);
	    	else {
	    		ResponseEntity<List<Produto>> re = new ResponseEntity<List<Produto>>(new ArrayList<Produto>(), HttpStatus.NO_CONTENT);
	    		return re;
	    	}
			
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity<List<Produto>> re = new ResponseEntity<List<Produto>>(new ArrayList<Produto>(),HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}
}
