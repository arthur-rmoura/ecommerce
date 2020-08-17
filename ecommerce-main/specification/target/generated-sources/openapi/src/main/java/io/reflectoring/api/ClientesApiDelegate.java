package io.reflectoring.api;

import io.reflectoring.model.Cliente;
import io.reflectoring.model.Pedido;
import io.reflectoring.model.Retorno;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ClientesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public interface ClientesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /clientes/{idCliente} : AtualizarCliente
     * Atualiza os dados de um cliente
     *
     * @param idCliente Identificador do cliente a ser atualizado (required)
     * @param cliente  (optional)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#atualizarCliente
     */
    default ResponseEntity<Retorno> atualizarCliente(String idCliente,
        Cliente cliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mensagem\" : \"Exemplo Sucesso\", \"sucesso\" : true, \"descricao\" : \"Texto longo descritivo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clientes : InserirCliente
     * Cria um novo cliente
     *
     * @param cliente  (optional)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#inserirCliente
     */
    default ResponseEntity<Retorno> inserirCliente(Cliente cliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mensagem\" : \"Exemplo Sucesso\", \"sucesso\" : true, \"descricao\" : \"Texto longo descritivo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /clientes/{idcliente}/pedidos : InserirPedido
     * Cria um novo pedido para o cliente
     *
     * @param idcliente Identificador do cliente (required)
     * @param pedido  (optional)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#inserirPedido
     */
    default ResponseEntity<Retorno> inserirPedido(String idcliente,
        Pedido pedido) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"mensagem\" : \"Exemplo Sucesso\", \"sucesso\" : true, \"descricao\" : \"Texto longo descritivo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes : ListarClientes
     * Lista todos os clientes de acordo com o filtro
     *
     * @param ordem Campo a ser usado como ordena��o da listagem (required)
     * @param status Filtro de status a ser aplicado (optional)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#listarClientes
     */
    default ResponseEntity<List<Cliente>> listarClientes(String ordem,
        String status) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data-cadastro\" : \"2000-01-23\", \"nome\" : \"Fulano de Tal\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"status\" : \"Ativo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes/{idcliente}/pedidos : ListarPedidosCliente
     * Lista todos os pedidos de um cliente
     *
     * @param idcliente Identificador do cliente (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#listarPedidosCliente
     */
    default ResponseEntity<List<Pedido>> listarPedidosCliente(String idcliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data-cadastro\" : \"2000-01-23T04:56:07.000+00:00\", \"idCliente\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"produtos\" : [ { \"produto\" : { \"valor\" : 2100.90, \"disponivel\" : true, \"nome\" : \"caixa de som\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"pedidos\" : [ null, null ] }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"quantidade\" : 0 }, { \"produto\" : { \"valor\" : 2100.90, \"disponivel\" : true, \"nome\" : \"caixa de som\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"pedidos\" : [ null, null ] }, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"quantidade\" : 0 } ], \"status-entrega\" : \"Entregue\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clientes/{idCliente} : ObterCliente
     * Recupera os dados do cliente selecionado
     *
     * @param idCliente Identificador do cliente a ser atualizado (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ClientesApi#obterCliente
     */
    default ResponseEntity<Cliente> obterCliente(String idCliente) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data-cadastro\" : \"2000-01-23\", \"nome\" : \"Fulano de Tal\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"status\" : \"Ativo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
