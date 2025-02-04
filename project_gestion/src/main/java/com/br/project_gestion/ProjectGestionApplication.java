package com.br.project_gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.br.project_gestion.infra.repository")
@EntityScan(basePackages = "com.br.project_gestion.domain.model")
public class ProjectGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGestionApplication.class, args);
	}

}
