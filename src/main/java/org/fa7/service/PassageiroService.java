package org.fa7.service;

import org.fa7.database.model.Passageiro;
import org.fa7.database.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {

	@Autowired 
	private PassageiroRepository repositorio;
	
	public void salvar(Passageiro passageiro){
		repositorio.save(passageiro);
	}
	
	public  Iterable<Passageiro> listar(){
		return repositorio.findAll();
	}
	
	public Passageiro buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Passageiro passageiro = this.buscar(id);
		if(passageiro != null) repositorio.delete(passageiro);
}
}
