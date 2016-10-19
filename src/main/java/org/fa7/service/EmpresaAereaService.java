package org.fa7.service;

import org.fa7.database.model.EmpresaAerea;
import org.fa7.database.repository.EmpresaAereaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaAereaService {

	@Autowired 
	private EmpresaAereaRepository repositorio;
	
	public void salvar(EmpresaAerea empresaAerea){
		repositorio.save(empresaAerea);
	}
	
	public  Iterable<EmpresaAerea> listar(){
		return repositorio.findAll();
	}
	
	public EmpresaAerea buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		EmpresaAerea empresaAerea = this.buscar(id);
		if(empresaAerea != null) repositorio.delete(empresaAerea);
}
}
