package org.fa7.service;

import org.fa7.database.model.TipoPagamento;
import org.fa7.database.repository.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPagamentoService {

	@Autowired 
	private TipoPagamentoRepository repositorio;
	
	public void salvar(TipoPagamento tipoPagamento){
		repositorio.save(tipoPagamento);
	}
	
	public  Iterable<TipoPagamento> listar(){
		return repositorio.findAll();
	}
	
	public TipoPagamento buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		TipoPagamento tipoPagamento = this.buscar(id);
		if(tipoPagamento != null) repositorio.delete(tipoPagamento);
}
}
