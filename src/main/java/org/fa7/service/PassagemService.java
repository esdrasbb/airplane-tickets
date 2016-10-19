package org.fa7.service;

import org.fa7.database.model.Passagem;
import org.fa7.database.repository.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassagemService {

	@Autowired 
	private PassagemRepository repositorio;
	
	public void salvar(Passagem passagem){
		repositorio.save(passagem);
	}
	
	public  Iterable<Passagem> listar(){
		return repositorio.findAll();
	}
	
	public Passagem buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Passagem passagem = this.buscar(id);
		if(passagem != null) repositorio.delete(passagem);
}
}
