package com.anhanguera.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.projeto.model.Produto;
import com.anhanguera.projeto.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> findAll(){
		return produtoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return produtoService.findById(id)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto create(@RequestBody Produto produto){
		return produtoService.create(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update (@PathVariable Long id, @RequestBody Produto produto){
		if(!produtoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produtoService.create(produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!produtoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produtoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
