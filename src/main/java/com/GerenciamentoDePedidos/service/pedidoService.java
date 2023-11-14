package com.GerenciamentoDePedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciamentoDePedidos.entities.Pedido;
import com.GerenciamentoDePedidos.repository.pedidoRepository;

@Service
public class pedidoService {
	private final pedidoRepository pedidoRepository;
	@Autowired
	public pedidoService(pedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public List<Pedido> getAllpedido (){
		return pedidoRepository.findAll();
	}

	public Pedido getpedidoById(Long id) {
		Optional<Pedido> Pedido = pedidoRepository.findById(id);
		return Pedido.orElse(null);
	}

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public Pedido updatePedido(Long id, Pedido updatedpedido) {
		Optional<Pedido> existingPedido = pedidoRepository.findById(id);
		if (existingPedido.isPresent()) {
			updatedpedido.setId(id);
			return pedidoRepository.save(updatedpedido);
		}
		return null;
	}

	public boolean deletePedido(Long id) {
		Optional<Pedido> existingPedido = pedidoRepository.findById(id);
		if (existingPedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
