package com.anhanguera.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anhanguera.projeto.model.Produto;
import com.anhanguera.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	@Transactional
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}
	
	@Transactional
	public Produto create(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto update(Long id, Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}
}
