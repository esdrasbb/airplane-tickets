package org.fa7.service;

import org.fa7.database.model.Voo;
import org.fa7.database.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VooService {

	@Autowired 
	private VooRepository repositorio;
	
	public void salvar(Voo voo){
		repositorio.save(voo);
	}
	
	public  Iterable<Voo> listar(){
		return repositorio.findAll();
	}
	
	public Voo buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Voo voo = this.buscar(id);
		if(voo != null) repositorio.delete(voo);
}
}
