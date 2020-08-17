package io.github.arthurrmoura.service.spec;

import java.io.IOException;
import java.util.ArrayList;

import io.github.arthurrmoura.model.Produto;

public interface ProdutoService {

	ArrayList<Produto> listarProdutos() throws IOException;

}
