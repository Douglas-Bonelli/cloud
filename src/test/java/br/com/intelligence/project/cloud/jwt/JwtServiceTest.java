package br.com.intelligence.project.cloud.jwt;

import org.junit.jupiter.api.Test;


public class JwtServiceTest {
	
	
	@Test
	public void geradorDeToken() {
		
		JwtService service = new JwtService();
		String token = service.createToken("Orgao115","30");
		System.out.println(token);
		
	}
	

}
