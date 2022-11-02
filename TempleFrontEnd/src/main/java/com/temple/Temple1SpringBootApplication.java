package com.temple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.temple.model.SpringSecurityAuditorAware;

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication(scanBasePackages = "com.temple.*")
@EnableJpaRepositories("com.*")
//@EntityScan("com.temple.*")
public class Temple1SpringBootApplication {
    
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Temple1SpringBootApplication.class, args);
	}

}
