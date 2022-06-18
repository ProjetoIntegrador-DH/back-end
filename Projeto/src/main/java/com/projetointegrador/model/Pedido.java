package com.projetointegrador.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;
	
	@ManyToOne
	@JsonIgnoreProperties("pedido")
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToMany(mappedBy = "pedido")
	@JsonIgnoreProperties("livros")
	private List<Livros> livros;
	
	private Double valorTotal;
	
	private int qtdeLivrosPedido;
	
	@UpdateTimestamp
	private LocalDateTime data;

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}

	public int getQtdeLivrosPedido() {
		return qtdeLivrosPedido;
	}

	public void setQtdeLivrosPedido(int qtdeLivrosPedido) {
		this.qtdeLivrosPedido = qtdeLivrosPedido;
	}
	
}
