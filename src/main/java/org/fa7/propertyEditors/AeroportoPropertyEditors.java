package org.fa7.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.fa7.database.model.Aeroporto;
import org.fa7.database.repository.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AeroportoPropertyEditors extends PropertyEditorSupport{
	
	@Autowired
	private AeroportoRepository aeroportoRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idAeroporto = Integer.parseInt(text);
		Aeroporto aeroporto = aeroportoRepositorios.findOne(idAeroporto);
		setValue(aeroporto);
	}

}