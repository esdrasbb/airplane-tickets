package org.fa7.controller;


import javax.validation.Valid;

import org.fa7.database.model.Aeroporto;
import org.fa7.database.model.EmpresaAerea;
import org.fa7.database.model.Voo;
import org.fa7.excessoes.VooException;
import org.fa7.propertyEditors.AeroportoPropertyEditors;
import org.fa7.propertyEditors.EmpresaAereaPropertyEditors;
import org.fa7.service.AeroportoService;
import org.fa7.service.EmpresaAereaService;
import org.fa7.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/voo")
public class VooController {
	
	@Autowired
	private VooService vooService;
	@Autowired
	private AeroportoService aeroportoService;
	@Autowired
	private EmpresaAereaService empresaAereaService;
	@Autowired
	private AeroportoPropertyEditors aeroportoPropertyEditors;
	@Autowired
	private EmpresaAereaPropertyEditors empresaAereaPropertyEditors;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarVoos(Model model){
		Iterable<Voo> voos = vooService.listar();
		
		model.addAttribute("titulo", "Listagem de Voos");
		model.addAttribute("voos", voos);
		model.addAttribute("aeroportos", aeroportoService.listar());
		model.addAttribute("empresaAereas", empresaAereaService.listar());
		
		return "voo/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarVoo(@Valid @ModelAttribute Voo voo, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			throw new VooException();
		}else{
			vooService.salvar(voo);
		}
		model.addAttribute("voos", vooService.listar());
		return "voo/tabela-voos";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarReserva(@PathVariable Integer id){
		
		try {
			vooService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Voo buscarReserva(@PathVariable Integer id){
		Voo voo = vooService.buscar(id);
		return voo;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Aeroporto.class, aeroportoPropertyEditors);
		webDataBinder.registerCustomEditor(EmpresaAerea.class, empresaAereaPropertyEditors);
	}

}