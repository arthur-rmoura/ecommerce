package io.github.arthurrmoura.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

/**
 * ProdutoPedido
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-09T22:48:22.984-03:00[America/Sao_Paulo]")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name = "produtoPedido")
public class ProdutoPedido {
	@JsonProperty("id")
	@Id
	@Basic(optional = false)
	@Column(name = "idProdutoPedido", nullable = false)
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	private UUID id;

	@JsonProperty("pedido")
	@JsonBackReference(value = "pedido")
	@JoinColumn(name = "idPedido", referencedColumnName = "idPedido", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Pedido pedido;

	@JsonProperty("produto")
	@JsonBackReference(value = "produto")
	@JoinColumn(name = "idProduto", referencedColumnName = "idProduto", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Produto produto;

	@JsonProperty("quantidade")
	@Basic(optional = false)
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	public ProdutoPedido id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador da entidade de relacionamento
	 * 
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
	 * 
	 * @return pedido
	 */
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	@JsonIgnore
	public Pedido getPedido() {
		return pedido;
	}
	
	@JsonIgnore
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdutoPedido produto(Produto produto) {
		this.produto = produto;
		return this;
	}

	/**
	 * Get produto
	 * 
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
	 * 
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
		return Objects.equals(this.id, produtoPedido.id) && Objects.equals(this.pedido, produtoPedido.pedido)
				&& Objects.equals(this.produto, produtoPedido.produto)
				&& Objects.equals(this.quantidade, produtoPedido.quantidade);
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
