package com.GerenciamentoDePedidos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "produto")
		private String produto;
		
		@Column(name = "quantidade")
		private int quantidade;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProduto(){
			return produto;
		}
		public void setProduto(String produto) {
			this.produto = produto;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
	}

