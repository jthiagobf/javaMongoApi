package com.apimongo.apimongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimongo.apimongo.model.Funcionario;
import com.apimongo.apimongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> listarTodos() {
		return this.funcionarioService.listarTodos();
	}
	
	@GetMapping("/{codigo}")
	public Funcionario listarPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.listarPorCodigo(codigo);
		
	}
	
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
	
	@GetMapping("/range")
	public List<Funcionario> listarFuncionarioPorRangeDeIdade(
			@RequestParam("de") Integer de, 
			@RequestParam("ate") Integer ate) {
		return this.funcionarioService.listarFuncionarioPorRangeDeIdade(de, ate);
	}
	
	@GetMapping("/por-nome")
	public List<Funcionario> listarFuncionarioPorNome(
			@RequestParam("nome") String nome) {
		return this.funcionarioService.listarFuncionarioPorNome(nome);
	}
	
}
