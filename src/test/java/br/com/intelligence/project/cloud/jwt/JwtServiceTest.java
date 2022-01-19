package br.com.intelligence.project.cloud.jwt;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.lang.Assert;

public class JwtServiceTest {
	
	//Instancia Global
	private JwtService service;

	
	@Test
	public void deveGerarToken() {
		
		this.service = new JwtService();
		String token = this.service.createToken("Orgao115","30");
		Assert.hasText(token);
		
	}
	
	@Test
	public void deveDecodificarObjetoToken() {
		
		String objeto = "Orgao115";
		
		this.service = new JwtService();
		String token = this.service.createToken( objeto ,"30");
		
		Assert.isTrue( objeto.equals( this.service.getSubject(token) ) );	
	}
	
	@Test
	public void deveVerificarExpiracao() {
		String objeto = "Orgao115";
		this.service = new JwtService();
		String token = this.service.createToken( objeto ,"30");
		
		Assert.isTrue( this.service.isValid(token));
	}
	
	
	
	@Test
	public void naoDevePermitirTokenExpirado() {
		
		String objeto = "Orgao115";
		this.service = new JwtService();
		String token = this.service.createToken( objeto ,"0");
		
		Assert.isTrue( !this.service.isValid(token));	
	}
	

}
