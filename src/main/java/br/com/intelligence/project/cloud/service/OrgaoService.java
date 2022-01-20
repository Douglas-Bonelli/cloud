package br.com.intelligence.project.cloud.service;

import java.util.List;
import java.util.Optional;

import br.com.intelligence.project.cloud.entity.Orgao;
import br.com.intelligence.project.cloud.helper.Status;

public interface OrgaoService {
	
	/**
	 * Metodo responsavel por listar Todos os Orgãos Ativos do Sistema
	 * @return
	 */
	List<Orgao> getAll();
	
	
	/**
	 * Metodo Que recebe o Codigo do Orgão e Recupera as Informações do mesmo
	 * @param id
	 * @return
	 */
	Optional<Orgao> findById(int id);
	
	
	/**
	 * Este Metodo Deleta um Orgão pelo seu Código
	 * @param id
	 * @return
	 */
	Status deleteById(int id);

}
