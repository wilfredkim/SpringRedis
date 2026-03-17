package com.wilfred.redis.springredis.config;


import org.apache.hc.core5.http.HttpHost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ElasticsearchConfig {
    @Bean
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                RestClient.builder(HttpHost.create("http://localhost:9200"))
        );
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate(RestHighLevelClient client) {
        return new ElasticsearchRestTemplate(client);
    }

}
