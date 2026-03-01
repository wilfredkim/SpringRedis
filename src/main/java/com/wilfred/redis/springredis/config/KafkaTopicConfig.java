package com.wilfred.redis.springredis.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("ecredit-topic").build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("ecredit-json-topic").build();
    }

}


