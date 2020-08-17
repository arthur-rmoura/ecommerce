package io.github.arthurrmoura.api.spec;

import io.github.arthurrmoura.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ProdutosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-10T14:24:51.240-03:00[America/Sao_Paulo]")

public interface ProdutosApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /produtos : ListarProdutos
     * Lista todos os produtos
     *
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     * @see ProdutosApi#listarProdutos
     */
    default ResponseEntity<List<Produto>> listarProdutos() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"valor\" : 2100.90, \"disponivel\" : true, \"nome\" : \"caixa de som\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"pedidos\" : [ null, null ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
