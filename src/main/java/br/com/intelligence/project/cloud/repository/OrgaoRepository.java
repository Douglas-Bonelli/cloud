package br.com.intelligence.project.cloud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.intelligence.project.cloud.entity.Orgao;

@Repository
public class OrgaoRepository {
	
	static List<Orgao> lista = new ArrayList<>();
	
	public List<Orgao> listAll() {
		
		
		lista.add( new Orgao( 88019 , "PM DE ACEGUA" ) );
		lista.add( new Orgao( 64500 , "PM DE AGUA SANTA" ) );
		lista.add( new Orgao( 40100 , "PM DE AGUDO" ) );
		lista.add( new Orgao( 40200 , "PM DE AJURICAB" ) );
		
		return lista;
		
	}

}
