package com.apimongo.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimongo.apimongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

	
	
	
}
