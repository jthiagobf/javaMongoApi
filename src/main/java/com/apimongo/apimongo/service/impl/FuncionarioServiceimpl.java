package com.apimongo.apimongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimongo.apimongo.model.Funcionario;
import com.apimongo.apimongo.repository.FuncionarioRepository;
import com.apimongo.apimongo.service.FuncionarioService;

@Service
public class FuncionarioServiceimpl implements FuncionarioService{
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> listarTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario listarPorCodigo(String codigo ) {
		return this.funcionarioRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionario inexistente"));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}

	

}
