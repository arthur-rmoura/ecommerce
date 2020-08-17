package io.github.arthurrmoura.api.spec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-10T14:24:51.240-03:00[America/Sao_Paulo]")

@Controller
@RequestMapping("${openapi.eCommerce.base-path:/ecommerce/v1}")
public class PedidosApiController implements PedidosApi {

    private final PedidosApiDelegate delegate;

    public PedidosApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) PedidosApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PedidosApiDelegate() {});
    }

    @Override
    public PedidosApiDelegate getDelegate() {
        return delegate;
    }

}
