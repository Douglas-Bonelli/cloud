package br.com.intelligence.project.cloud.service.imp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.intelligence.project.cloud.entity.Orgao;
import io.jsonwebtoken.lang.Assert;

public class OrgaoServiceImpTest {
	
	
	@Autowired
	private OrgaoServiceImp service =  new OrgaoServiceImp();
	
		
	@Test
	public void deveListarOrgaos() {
		
		this.service.getAll().stream()
						     .forEach( c-> System.out.println(c.toString()));		
	
	}
	
	@Test
	public void deveRetornarOrgao() {
		
		Optional<Orgao> opt = service.findById(88019);
		Assert.isTrue(opt.isPresent());
		
	}
	
	@Test
	public void naoDeveRetornarOrgao() {
		
		Optional<Orgao> opt = service.findById(0);
		Assert.isTrue(opt.isEmpty());
		
	}

}
