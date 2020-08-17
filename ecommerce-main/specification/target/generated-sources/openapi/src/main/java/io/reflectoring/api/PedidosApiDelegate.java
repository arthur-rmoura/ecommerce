package io.reflectoring.api;

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
 * A delegate to be called by the {@link PedidosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public interface PedidosApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /pedidos : ListarPedidos
     * Lista todos os pedidos conforme o filtro de status da entrega
     *
     * @param statusEntrega Filtro de status a ser aplicado na listagem (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see PedidosApi#listarPedidos
     */
    default ResponseEntity<List<Pedido>> listarPedidos(String statusEntrega) {
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

}
