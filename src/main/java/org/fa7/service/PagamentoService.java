package org.fa7.service;

import org.fa7.database.model.Pagamento;
import org.fa7.database.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

	@Autowired 
	private PagamentoRepository repositorio;
	
	public void salvar(Pagamento pagamento){
		repositorio.save(pagamento);
	}
	
	public  Iterable<Pagamento> listar(){
		return repositorio.findAll();
	}
	
	public Pagamento buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Pagamento pagamento = this.buscar(id);
		if(pagamento != null) repositorio.delete(pagamento);
}
}
