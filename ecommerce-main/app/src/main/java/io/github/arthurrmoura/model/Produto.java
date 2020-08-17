package io.github.arthurrmoura.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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
 * Produto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-09T22:48:22.984-03:00[America/Sao_Paulo]")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name = "produto")
public class Produto {
	@JsonProperty("id")
	@Id
	@Basic(optional = false)
	@Column(name = "idProduto", nullable = false)
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	private UUID id;

	@JsonProperty("nome")
	@Basic(optional = false)
	@Column(name = "nome", nullable = false)
	private String nome;

	@JsonProperty("valor")
	@Basic(optional = false)
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@JsonProperty("disponivel")
	@Basic(optional = true)
	@Column(name = "disponivel", nullable = true)
	private Boolean disponivel;

	@JsonIgnore
	@JsonManagedReference(value = "produto")
	@Valid
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produto", fetch = FetchType.LAZY)
	@XmlTransient
	private List<ProdutoPedido> pedidos;

	public Produto id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador do produto
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * @return pedidos
	 */
	@ApiModelProperty(value = "")

	@Valid
	@JsonIgnore
	public List<ProdutoPedido> getPedidos() {
		return pedidos;
	}
	
	@JsonIgnore
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
		return Objects.equals(this.id, produto.id) && Objects.equals(this.nome, produto.nome)
				&& Objects.equals(this.valor, produto.valor) && Objects.equals(this.disponivel, produto.disponivel)
				&& Objects.equals(this.pedidos, produto.pedidos);
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
