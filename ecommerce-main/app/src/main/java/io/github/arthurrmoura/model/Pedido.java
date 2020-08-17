package io.github.arthurrmoura.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

/**
 * Pedido
 */
@SuppressWarnings("serial")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-08T09:13:31.085-03:00[America/Sao_Paulo]")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	@JsonProperty("id")
	@Id
	@Basic(optional = false)
	@Column(name = "idPedido", nullable = false)
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	private UUID id;

	@JsonProperty("data-cadastro")
	@Basic(optional = false)
	@Column(name = "dataCadastro", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private OffsetDateTime dataCadastro;

	@JsonProperty("idCliente")
	@Basic(optional = false)
	@Column(name = "idCliente", nullable = false)
	@Type(type = "uuid-char")
	private UUID idCliente;

	@JsonProperty("status-entrega")
	@Basic(optional = true)
	@Column(name = "statusEntrega", nullable = true)
	private String statusEntrega;

	@JsonProperty("produtos")
	@JsonManagedReference(value = "pedido")
	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pedido", fetch = FetchType.LAZY)
	@XmlTransient
	private List<ProdutoPedido> produtos;

	public Pedido id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador do pedido
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
		return Objects.equals(this.id, pedido.id) && Objects.equals(this.dataCadastro, pedido.dataCadastro)
				&& Objects.equals(this.idCliente, pedido.idCliente)
				&& Objects.equals(this.statusEntrega, pedido.statusEntrega)
				&& Objects.equals(this.produtos, pedido.produtos);
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
