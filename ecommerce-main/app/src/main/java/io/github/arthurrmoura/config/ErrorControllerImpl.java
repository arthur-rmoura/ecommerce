package io.github.arthurrmoura.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import io.github.arthurrmoura.model.Retorno;

@RestController
public class ErrorControllerImpl implements ErrorController {

	private static final String PATH = "/error";
	private final ErrorAttributes errorAttributes;

	@Autowired
	public ErrorControllerImpl(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes não podem ser null");
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping(value = PATH)
	public ResponseEntity<Retorno> error(HttpServletRequest req) {
		Map<String, Object> map = getErrorAttributes(req);
		String sourceEnpoint="";
		String parametroFaltante="";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			//if(entry.getValue().getClass().getName().equals("String")) {
			    if((entry.getValue().toString()).contains("cliente")) {
			    	sourceEnpoint=" do 'Cliente'";
			    	parametroFaltante=" 'ordem'";
			    }
			    else if((entry.getValue().toString()).contains("pedido")) {
			    	sourceEnpoint=" do 'Pedido'";
			    	parametroFaltante=" 'status-entrega'";
			    }
			    else {
			    	sourceEnpoint="";
			    	parametroFaltante="";
			    }
			//}
		}
		
		if(!sourceEnpoint.equals("")) {
			Retorno rt = new Retorno();
			rt.setMensagem("Paramêtro requerido" +parametroFaltante + sourceEnpoint + " não informado");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt, HttpStatus.BAD_REQUEST);
			return re;
		}
		else {
			Retorno rt = new Retorno();
			rt.setMensagem("Ocorreu um erro ao processar a sua solicitação, por favor tente novamente");
			rt.setDescricao("Erro interno do servidor ainda não tratado");
			rt.setSucesso(false);
			ResponseEntity<Retorno> re = new ResponseEntity<Retorno>(rt, HttpStatus.INTERNAL_SERVER_ERROR);
			return re;
		}
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
		WebRequest webRequest = new ServletWebRequest(request);
		return this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}