package io.github.arthurrmoura.api.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.arthurrmoura.api.spec.PedidosApiDelegate;
import io.github.arthurrmoura.model.Pedido;
import io.github.arthurrmoura.service.spec.PedidoService;

@Service
public class PedidosApiDelegateImpl implements PedidosApiDelegate{
	
	@Autowired
	private PedidoService pedidoService;
	
	@Override
	public ResponseEntity<List<Pedido>> listarPedidos(String statusEntrega) {
		try {
			ArrayList<Pedido> pedidos;
			List<String> colunas = new ArrayList<String>();
			colunas.add("pendente"); colunas.add("cancelado"); colunas.add("entregue"); colunas.add("Pendente"); colunas.add("Cancelado"); colunas.add("Entregue");
			if(statusEntrega != null && colunas.contains(statusEntrega)) {
				pedidos = pedidoService.listarPedidos(statusEntrega);
				if(!pedidos.isEmpty())
		    		return ResponseEntity.ok(pedidos);
		    	else {
		    		ResponseEntity<List<Pedido>> re = new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(), HttpStatus.NO_CONTENT);
		    		return re;
		    	}
			}
			else {
				ResponseEntity<List<Pedido>> re = new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(), HttpStatus.BAD_REQUEST);
	    		return re;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			ResponseEntity<List<Pedido>> re = new ResponseEntity<List<Pedido>>(new ArrayList<Pedido>(),HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}	
}
