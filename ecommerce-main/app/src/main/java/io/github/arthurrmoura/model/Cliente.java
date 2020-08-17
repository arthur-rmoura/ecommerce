package io.github.arthurrmoura.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import org.hibernate.annotations.Type;

/**
 * Cliente
 */
@SuppressWarnings("serial")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-06T19:44:35.906-03:00[America/Sao_Paulo]")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	
	@JsonProperty("id")
	@Id
	@Basic(optional = false)
	@Column(name = "idCliente", nullable = false)
	//@GeneratedValue(generator = "uuid")
	//@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="uuid-char")
	private UUID id;

	@JsonProperty("nome")
	@Basic(optional = false)
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@JsonProperty("data-cadastro")
	@Basic(optional = false)
	@Column(name = "dataCadastro", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@JsonProperty("status")
	@Basic(optional = true)
	@Column(name = "status", nullable = true, length = 50)
	private String status;

	public Cliente id(UUID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Identificador do cliente
	 * 
	 * @return id
	 */
	@ApiModelProperty(value = "Identificador do cliente")

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
	 * 
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
	 * 
	 * @return dataCadastro
	 */
	@ApiModelProperty(value = "Data de cadastro do cliente")

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
	 * 
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
		return Objects.equals(this.id, cliente.id) && Objects.equals(this.nome, cliente.nome)
				&& Objects.equals(this.dataCadastro, cliente.dataCadastro)
				&& Objects.equals(this.status, cliente.status);
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
