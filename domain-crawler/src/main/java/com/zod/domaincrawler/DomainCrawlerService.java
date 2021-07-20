package com.zod.domaincrawler;

import com.zod.common.model.dto.Domain;
import com.zod.common.model.dto.DomainList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DomainCrawlerService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private KafkaTemplate<String,Domain> kafkaTemplate;
  private final String KAFKA_TOPIC = "web-domains";

  public void crawl(String name) {

    DomainList domainList =
            restTemplate.getForObject("https://api.domainsdb.info/v1/domains/search?domain=" + name + "&zone=com", DomainList.class );
    domainList.getDomains().forEach(domain ->
           System.out.println(domain.getDomain()));
    domainList.getDomains().forEach(domain ->
            kafkaTemplate.send(KAFKA_TOPIC, domain));
  }
}
