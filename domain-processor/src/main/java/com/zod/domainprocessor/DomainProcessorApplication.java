package com.zod.domainprocessor;

import com.zod.common.model.dto.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@SpringBootApplication
public class DomainProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainProcessorApplication.class, args);
	}


	@Bean
	public Function<KStream<String, Domain>, KStream<String,Domain>> domainProcessor(){

		return kstream -> kstream.filter((key,domain)->{
			if(domain.isDead()){
				System.out.println("Inactive domain : " + domain.getDomain());
			}else{
				System.out.println("Active domain : " + domain.getDomain());
			}
			return !domain.isDead();
		});
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
