package com.apimongo.apimongo.service;

import java.util.List;

import com.apimongo.apimongo.model.Funcionario;

public interface FuncionarioService {
	
	public List<Funcionario> listarTodos();
	
	public Funcionario listarPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);




}
