package io.reflectoring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.reflectoring.model.ProdutoPedido;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pedido
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public class Pedido   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("data-cadastro")
  private OffsetDateTime dataCadastro;

  @JsonProperty("idCliente")
  private UUID idCliente;

  @JsonProperty("status-entrega")
  private String statusEntrega;

  @JsonProperty("produtos")
  @Valid
  private List<ProdutoPedido> produtos = null;

  public Pedido id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do pedido 
   * @return id
  */
  @ApiModelProperty(required = true, value = "Identificador do pedido ")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Pedido dataCadastro(OffsetDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
    return this;
  }

  /**
   * Data de cadasro do pedido
   * @return dataCadastro
  */
  @ApiModelProperty(required = true, value = "Data de cadasro do pedido")
  @NotNull

  @Valid

  public OffsetDateTime getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(OffsetDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Pedido idCliente(UUID idCliente) {
    this.idCliente = idCliente;
    return this;
  }

  /**
   * Identificador do cliente que efetuou a compra
   * @return idCliente
  */
  @ApiModelProperty(required = true, value = "Identificador do cliente que efetuou a compra")
  @NotNull

  @Valid

  public UUID getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(UUID idCliente) {
    this.idCliente = idCliente;
  }

  public Pedido statusEntrega(String statusEntrega) {
    this.statusEntrega = statusEntrega;
    return this;
  }

  /**
   * Status do processo de entrega (Pendente, Cancelado, Entregue)
   * @return statusEntrega
  */
  @ApiModelProperty(example = "Entregue", required = true, value = "Status do processo de entrega (Pendente, Cancelado, Entregue)")
  @NotNull


  public String getStatusEntrega() {
    return statusEntrega;
  }

  public void setStatusEntrega(String statusEntrega) {
    this.statusEntrega = statusEntrega;
  }

  public Pedido produtos(List<ProdutoPedido> produtos) {
    this.produtos = produtos;
    return this;
  }

  public Pedido addProdutosItem(ProdutoPedido produtosItem) {
    if (this.produtos == null) {
      this.produtos = new ArrayList<>();
    }
    this.produtos.add(produtosItem);
    return this;
  }

  /**
   * Get produtos
   * @return produtos
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ProdutoPedido> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<ProdutoPedido> produtos) {
    this.produtos = produtos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pedido pedido = (Pedido) o;
    return Objects.equals(this.id, pedido.id) &&
        Objects.equals(this.dataCadastro, pedido.dataCadastro) &&
        Objects.equals(this.idCliente, pedido.idCliente) &&
        Objects.equals(this.statusEntrega, pedido.statusEntrega) &&
        Objects.equals(this.produtos, pedido.produtos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataCadastro, idCliente, statusEntrega, produtos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedido {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dataCadastro: ").append(toIndentedString(dataCadastro)).append("\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    statusEntrega: ").append(toIndentedString(statusEntrega)).append("\n");
    sb.append("    produtos: ").append(toIndentedString(produtos)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

