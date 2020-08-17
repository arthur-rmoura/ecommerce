package io.reflectoring.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

@Controller
@RequestMapping("${openapi.eCommerce.base-path:/ecommerce/v1}")
public class ProdutosApiController implements ProdutosApi {

    private final ProdutosApiDelegate delegate;

    public ProdutosApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ProdutosApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProdutosApiDelegate() {});
    }

    @Override
    public ProdutosApiDelegate getDelegate() {
        return delegate;
    }

}
