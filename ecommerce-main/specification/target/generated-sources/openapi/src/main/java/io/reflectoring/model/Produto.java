package io.reflectoring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.reflectoring.model.ProdutoPedido;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Produto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public class Produto   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("valor")
  private BigDecimal valor;

  @JsonProperty("disponivel")
  private Boolean disponivel;

  @JsonProperty("pedidos")
  @Valid
  private List<ProdutoPedido> pedidos = null;

  public Produto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do produto
   * @return id
  */
  @ApiModelProperty(required = true, value = "Identificador do produto")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do produto
   * @return nome
  */
  @ApiModelProperty(example = "caixa de som", required = true, value = "Nome do produto")
  @NotNull


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto valor(BigDecimal valor) {
    this.valor = valor;
    return this;
  }

  /**
   * Valor do produto
   * @return valor
  */
  @ApiModelProperty(example = "2100.90", required = true, value = "Valor do produto")
  @NotNull

  @Valid

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Produto disponivel(Boolean disponivel) {
    this.disponivel = disponivel;
    return this;
  }

  /**
   * Indicador de disponibilidade do produto
   * @return disponivel
  */
  @ApiModelProperty(example = "true", value = "Indicador de disponibilidade do produto")


  public Boolean getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(Boolean disponivel) {
    this.disponivel = disponivel;
  }

  public Produto pedidos(List<ProdutoPedido> pedidos) {
    this.pedidos = pedidos;
    return this;
  }

  public Produto addPedidosItem(ProdutoPedido pedidosItem) {
    if (this.pedidos == null) {
      this.pedidos = new ArrayList<>();
    }
    this.pedidos.add(pedidosItem);
    return this;
  }

  /**
   * Get pedidos
   * @return pedidos
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ProdutoPedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<ProdutoPedido> pedidos) {
    this.pedidos = pedidos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return Objects.equals(this.id, produto.id) &&
        Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.valor, produto.valor) &&
        Objects.equals(this.disponivel, produto.disponivel) &&
        Objects.equals(this.pedidos, produto.pedidos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, valor, disponivel, pedidos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
    sb.append("    disponivel: ").append(toIndentedString(disponivel)).append("\n");
    sb.append("    pedidos: ").append(toIndentedString(pedidos)).append("\n");
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

