package com.GerenciamentoDePedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciamentoDePedidos.entities.Pedido;
import com.GerenciamentoDePedidos.service.pedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin (origins ="")
public class pedidoController {
	private final pedidoService pedidoService;
	
	@Autowired
	public pedidoController(pedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getProductById(@PathVariable Long id) {
		Pedido pedido = pedidoService.getpedidoById(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Pedido>> getAllcursos() {
		List<Pedido> pedido = pedidoService.getAllpedido();
		return ResponseEntity.ok(pedido);
	}
	@PostMapping
	public ResponseEntity<Pedido> criarpedido(@RequestBody @Valid Pedido pedido){
		Pedido criarpedido = pedidoService.salvarPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarpedido);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody @Valid Pedido pedido) {
		Pedido updatedPedido = pedidoService.updatePedido(id, pedido);
		if (updatedPedido != null) {
			return ResponseEntity.ok(updatedPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> deletecursos(@PathVariable Long id) {
		boolean deleted = pedidoService.deletePedido(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}
