package org.fa7.service;

import org.fa7.database.model.Aeroporto;
import org.fa7.database.repository.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AeroportoService {

	@Autowired 
	private AeroportoRepository repositorio;
	
	public void salvar(Aeroporto aeroporto){
		repositorio.save(aeroporto);
	}
	
	public  Iterable<Aeroporto> listar(){
		return repositorio.findAll();
	}
	
	public Aeroporto buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Aeroporto aeroporto = this.buscar(id);
		if(aeroporto != null) repositorio.delete(aeroporto);
}
}
