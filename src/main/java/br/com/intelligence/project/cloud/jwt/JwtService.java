package br.com.intelligence.project.cloud.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	
	//Assinatura em Base 64
	private final String chaveAssinatura = "SW50ZWxsaWdlbmNlV2Vi";
	
	public JwtService() {}
	
	/**
	 * Metodo Responsavel por gerar Token de Acesso basedo em Uma String / Por Exemplo "UserName"
	 * @param stringToToken -> String Que será Utilizada no Token
	 * @param minutosExpiracao -> Tempo de Validade do Token em minutos
	 * @return
	 */
	public String createToken(String stringToToken , String minutosExpiracao ){

		long expString = Long.valueOf(minutosExpiracao);
		
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
		Date data = Date.from( dataHoraExpiracao.atZone( ZoneId.systemDefault() ).toInstant() );

		return Jwts.builder()
				.setSubject( stringToToken ) //String Passada Pelo Usuário -> Username Por Exemplo
				.setExpiration(data)
				.signWith(  SignatureAlgorithm.HS512 , chaveAssinatura )
				.compact();
	
	}
	
	
	/**
	 * Metodo Responsavel Por Retornar Todos os Claims de um Token
	 * @param token
	 * @return
	 */
	private Claims getClaims( String token ){

		return Jwts
				.parser()
			    .setSigningKey( chaveAssinatura )
			    .parseClaimsJws( token )
			    .getBody();
	}
	
	
	
	/**
	 * Metodo Que Recebe um Token e Verifica se a validade ( Tempo de Expiração ) Esta OK
	 * @param token
	 * @return
	 * @throws ExpiredJwtException
	 */
	public boolean isValid(String token) throws ExpiredJwtException {
		
		try{
			Claims claims = getClaims( token );
			Date dataExpiracao = claims.getExpiration();
			
			LocalDateTime data = dataExpiracao.toInstant()
											  .atZone( ZoneId.systemDefault())
											   .toLocalDateTime();

		return !LocalDateTime.now().isAfter(data);
		
		}catch(Exception e) {return false; }
		
	}
	
	
	/**
	 * Metodo Que recebe um Token e Retorno o subject,  No Caso a String Enviada na Criação
	 * @param token
	 * @return
	 * @throws ExpiredJwtException
	 */
	public String getSubject( String token  ) throws ExpiredJwtException {
		return getClaims( token ).getSubject();
	}

	
	
	
	
	
}
