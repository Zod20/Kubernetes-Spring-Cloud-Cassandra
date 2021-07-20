package com.zod.domainservice;

import com.zod.common.model.dto.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class DomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainServiceApplication.class, args);
	}


	@Bean
	public Consumer<KStream<String, Domain>> domainService(){
		return kstream -> kstream.foreach((key,domain) -> {
			System.out.println(String.format("Domain consumed [%s] Status [%s]", domain.getDomain(), domain.isDead()));
		});
	}

}
