package org.fa7.service;

import org.fa7.database.model.Cidade;
import org.fa7.database.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

	@Autowired 
	private CidadeRepository repositorio;
	
	public void salvar(Cidade cidade){
		repositorio.save(cidade);
	}
	
	public  Iterable<Cidade> listar(){
		return repositorio.findAll();
	}
	
	public Cidade buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Cidade cidade = this.buscar(id);
		if(cidade != null) repositorio.delete(cidade);
}
}
