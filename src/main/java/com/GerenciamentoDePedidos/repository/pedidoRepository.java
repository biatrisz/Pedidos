package com.GerenciamentoDePedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GerenciamentoDePedidos.entities.Pedido;

public interface pedidoRepository extends JpaRepository <Pedido, Long>{

}
