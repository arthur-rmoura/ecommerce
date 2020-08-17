/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.reflectoring.api;

import io.reflectoring.model.Cliente;
import io.reflectoring.model.Pedido;
import io.reflectoring.model.Retorno;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

@Validated
@Api(value = "clientes", description = "the clientes API")
public interface ClientesApi {

    default ClientesApiDelegate getDelegate() {
        return new ClientesApiDelegate() {};
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
     */
    @ApiOperation(value = "AtualizarCliente", nickname = "atualizarCliente", notes = "Atualiza os dados de um cliente", response = Retorno.class, authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Retorno.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes/{idCliente}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<Retorno> atualizarCliente(@ApiParam(value = "Identificador do cliente a ser atualizado",required=true) @PathVariable("idCliente") String idCliente,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Cliente cliente) {
        return getDelegate().atualizarCliente(idCliente, cliente);
    }


    /**
     * POST /clientes : InserirCliente
     * Cria um novo cliente
     *
     * @param cliente  (optional)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "InserirCliente", nickname = "inserirCliente", notes = "Cria um novo cliente", response = Retorno.class, authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Retorno.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Retorno> inserirCliente(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Cliente cliente) {
        return getDelegate().inserirCliente(cliente);
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
     */
    @ApiOperation(value = "InserirPedido", nickname = "inserirPedido", notes = "Cria um novo pedido para o cliente", response = Retorno.class, authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Retorno.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes/{idcliente}/pedidos",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Retorno> inserirPedido(@ApiParam(value = "Identificador do cliente",required=true) @PathVariable("idcliente") String idcliente,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) Pedido pedido) {
        return getDelegate().inserirPedido(idcliente, pedido);
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
     */
    @ApiOperation(value = "ListarClientes", nickname = "listarClientes", notes = "Lista todos os clientes de acordo com o filtro", response = Cliente.class, responseContainer = "List", authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Cliente.class, responseContainer = "List"),
        @ApiResponse(code = 204, message = "No Content", response = Object.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Cliente>> listarClientes(@NotNull @ApiParam(value = "Campo a ser usado como ordena��o da listagem", required = true) @Valid @RequestParam(value = "ordem", required = true) String ordem,@ApiParam(value = "Filtro de status a ser aplicado") @Valid @RequestParam(value = "status", required = false) String status) {
        return getDelegate().listarClientes(ordem, status);
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
     */
    @ApiOperation(value = "ListarPedidosCliente", nickname = "listarPedidosCliente", notes = "Lista todos os pedidos de um cliente", response = Pedido.class, responseContainer = "List", authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Pedido.class, responseContainer = "List"),
        @ApiResponse(code = 204, message = "No Content", response = Object.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes/{idcliente}/pedidos",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Pedido>> listarPedidosCliente(@ApiParam(value = "Identificador do cliente",required=true) @PathVariable("idcliente") String idcliente) {
        return getDelegate().listarPedidosCliente(idcliente);
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
     */
    @ApiOperation(value = "ObterCliente", nickname = "obterCliente", notes = "Recupera os dados do cliente selecionado", response = Cliente.class, authorizations = {
        @Authorization(value = "client_id")
    }, tags={ "Clientes", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Cliente.class),
        @ApiResponse(code = 204, message = "No Content", response = Object.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Retorno.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Retorno.class) })
    @RequestMapping(value = "/clientes/{idCliente}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Cliente> obterCliente(@ApiParam(value = "Identificador do cliente a ser atualizado",required=true) @PathVariable("idCliente") String idCliente) {
        return getDelegate().obterCliente(idCliente);
    }

}