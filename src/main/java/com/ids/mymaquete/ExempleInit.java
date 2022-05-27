package com.ids.mymaquete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ids.mymaquete.repository.ExempleRepository;
import com.ids.mymaquete.service.ExempleService;

@Configuration
public class ExempleInit {
	@Bean
	CommandLineRunner go(ExempleRepository dao, ExempleService service) {
		return a -> {
			if (dao.findAll().size() == 0)
				dao.saveAll(service.init());
		};
	}
}
