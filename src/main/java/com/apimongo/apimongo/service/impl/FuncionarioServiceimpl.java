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
		
		Funcionario chefe =
				this.funcionarioRepository
				.findById(funcionario.getChefe().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));
		
		funcionario.setChefe(chefe);
		
		return this.funcionarioRepository.save(funcionario);
	}
	
	@Override
	public List<Funcionario> listarFuncionarioPorRangeDeIdade(Integer de, Integer ate) {
		
		return this.funcionarioRepository.listarFuncionariosPorRangeDeIdade(de, ate);
		
	}

	@Override
	public List<Funcionario> listarFuncionarioPorNome(String nome) {
		return this.funcionarioRepository.findByNome(nome);
	}

}
