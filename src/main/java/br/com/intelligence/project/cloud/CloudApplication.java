package br.com.intelligence.project.cloud;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.intelligence.project.cloud.jwt.JwtService;

@SpringBootApplication
public class CloudApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
	}
	
	

}
