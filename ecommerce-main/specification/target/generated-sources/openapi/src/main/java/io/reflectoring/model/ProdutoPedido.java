package io.reflectoring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.reflectoring.model.Pedido;
import io.reflectoring.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProdutoPedido
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public class ProdutoPedido   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("pedido")
  private Pedido pedido;

  @JsonProperty("produto")
  private Produto produto;

  @JsonProperty("quantidade")
  private Integer quantidade;

  public ProdutoPedido id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador da entidade de relacionamento 
   * @return id
  */
  @ApiModelProperty(required = true, value = "Identificador da entidade de relacionamento ")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ProdutoPedido pedido(Pedido pedido) {
    this.pedido = pedido;
    return this;
  }

  /**
   * Get pedido
   * @return pedido
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public ProdutoPedido produto(Produto produto) {
    this.produto = produto;
    return this;
  }

  /**
   * Get produto
   * @return produto
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public ProdutoPedido quantidade(Integer quantidade) {
    this.quantidade = quantidade;
    return this;
  }

  /**
   * Quantidade solicitada no pedido
   * @return quantidade
  */
  @ApiModelProperty(required = true, value = "Quantidade solicitada no pedido")
  @NotNull


  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProdutoPedido produtoPedido = (ProdutoPedido) o;
    return Objects.equals(this.id, produtoPedido.id) &&
        Objects.equals(this.pedido, produtoPedido.pedido) &&
        Objects.equals(this.produto, produtoPedido.produto) &&
        Objects.equals(this.quantidade, produtoPedido.quantidade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pedido, produto, quantidade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProdutoPedido {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pedido: ").append(toIndentedString(pedido)).append("\n");
    sb.append("    produto: ").append(toIndentedString(produto)).append("\n");
    sb.append("    quantidade: ").append(toIndentedString(quantidade)).append("\n");
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

