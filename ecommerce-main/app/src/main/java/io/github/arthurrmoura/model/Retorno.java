package io.github.arthurrmoura.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Retorno
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-08T09:13:31.085-03:00[America/Sao_Paulo]")

public class Retorno   {
  @JsonProperty("mensagem")
  private String mensagem;

  @JsonProperty("sucesso")
  private Boolean sucesso;

  @JsonProperty("descricao")
  private String descricao;

  public Retorno mensagem(String mensagem) {
    this.mensagem = mensagem;
    return this;
  }

  /**
   * Mensagem de retorno do processamento
   * @return mensagem
  */
  @ApiModelProperty(example = "Exemplo Sucesso", value = "Mensagem de retorno do processamento")


  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public Retorno sucesso(Boolean sucesso) {
    this.sucesso = sucesso;
    return this;
  }

  /**
   * Indica��o de sucesso o falha
   * @return sucesso
  */
  @ApiModelProperty(value = "Indica��o de sucesso o falha")


  public Boolean getSucesso() {
    return sucesso;
  }

  public void setSucesso(Boolean sucesso) {
    this.sucesso = sucesso;
  }

  public Retorno descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Descri��o longa do retorno
   * @return descricao
  */
  @ApiModelProperty(example = "Texto longo descritivo", value = "Descri��o longa do retorno")


  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Retorno retorno = (Retorno) o;
    return Objects.equals(this.mensagem, retorno.mensagem) &&
        Objects.equals(this.sucesso, retorno.sucesso) &&
        Objects.equals(this.descricao, retorno.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensagem, sucesso, descricao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Retorno {\n");
    
    sb.append("    mensagem: ").append(toIndentedString(mensagem)).append("\n");
    sb.append("    sucesso: ").append(toIndentedString(sucesso)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
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

