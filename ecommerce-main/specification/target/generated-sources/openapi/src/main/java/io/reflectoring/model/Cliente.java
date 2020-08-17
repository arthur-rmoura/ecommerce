package io.reflectoring.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Cliente
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-12T18:44:16.882-03:00[America/Sao_Paulo]")

public class Cliente   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("data-cadastro")
  private LocalDate dataCadastro;

  @JsonProperty("status")
  private String status;

  public Cliente id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador do cliente
   * @return id
  */
  @ApiModelProperty(required = true, value = "Identificador do cliente")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Cliente nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do cliente
   * @return nome
  */
  @ApiModelProperty(example = "Fulano de Tal", required = true, value = "Nome do cliente")
  @NotNull


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cliente dataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
    return this;
  }

  /**
   * Data de cadastro do cliente
   * @return dataCadastro
  */
  @ApiModelProperty(required = true, value = "Data de cadastro do cliente")
  @NotNull

  @Valid

  public LocalDate getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Cliente status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status do cliente (Ativo/Inativo)
   * @return status
  */
  @ApiModelProperty(example = "Ativo", value = "Status do cliente (Ativo/Inativo)")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.id, cliente.id) &&
        Objects.equals(this.nome, cliente.nome) &&
        Objects.equals(this.dataCadastro, cliente.dataCadastro) &&
        Objects.equals(this.status, cliente.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, dataCadastro, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    dataCadastro: ").append(toIndentedString(dataCadastro)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

