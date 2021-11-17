package com.tribunalEleitoral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class TribunalEleitoralApplication {

	public static void main(String[] args) {
		SpringApplication.run(TribunalEleitoralApplication.class, args);
	}

}
