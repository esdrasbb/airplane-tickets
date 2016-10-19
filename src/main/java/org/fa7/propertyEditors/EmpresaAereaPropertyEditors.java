package org.fa7.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.fa7.database.model.EmpresaAerea;
import org.fa7.database.repository.EmpresaAereaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaAereaPropertyEditors extends PropertyEditorSupport{
	
	@Autowired
	private EmpresaAereaRepository empresaAereaRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idEmpresaAerea = Integer.parseInt(text);
		EmpresaAerea empresaAerea = empresaAereaRepositorios.findOne(idEmpresaAerea);
		setValue(empresaAerea);
	}

}