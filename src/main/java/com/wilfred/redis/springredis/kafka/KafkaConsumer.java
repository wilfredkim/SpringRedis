package com.wilfred.redis.springredis.kafka;

import com.wilfred.redis.springredis.payload.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "ecredit-topic", groupId = "ecredit-group")
    public void consume(String message) {
        LOGGER.info("Consumed message::::::::::::::::: {}", message);
    }

    @KafkaListener(topics = "ecredit-json-topic", groupId = "ecredit-group")
    public void consume(Customer customer) {
        LOGGER.info("Saving customer::::::::::::::::: {}", customer.getName());
    }
}
