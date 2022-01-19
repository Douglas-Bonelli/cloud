package br.com.intelligence.project.cloud.service;

import java.util.List;
import java.util.Optional;

import br.com.intelligence.project.cloud.entity.Orgao;

public interface OrgaoService {
	
	List<Orgao> getAll();
	
	Optional<Orgao> findById(int id);

}
