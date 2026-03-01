package com.wilfred.redis.springredis.kafka;

import com.wilfred.redis.springredis.payload.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public CustomerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void saveCustomer(Customer customer) {
        LOGGER.info("Sending message::::::::::::::::: {}", customer.getName());
        Message<Customer> message = MessageBuilder.withPayload(customer).setHeader(KafkaHeaders.TOPIC, "ecredit-json-topic").build();
        kafkaTemplate.send(message);
    }

    //consumer


}
