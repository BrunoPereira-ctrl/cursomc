package com.brunopereira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunopereira.cursomc.domain.Categoria;
import com.brunopereira.cursomc.repositories.CategoriaRepository;
import com.brunopereira.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado: "+ id + ", Tipo: " + Categoria.class.getName()));
	}
}
