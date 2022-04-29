package com.live.kafka.consumer.consumer;

import com.live.kafka.consumer.entities.CarDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Quando tiver mais de uma instancia de um servico consumer para um mesmo topico,
 * as particoes e as mensagens serao automaticamente divididas entre as instancias pelo proprio Kafka
 */
@Component
public class CarConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    // Metodo que esta escutando as mensagens que chegam no topico
    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "carKafkaListenerContainerFactory") // Estamos passando o metodo que criamos no containerFactory
    public void listenerTopicCar(ConsumerRecord<String, CarDTO> record) {
        logger.info("Received Message Partition = " + record.partition());
        logger.info("Received Message Value = " + record.value());

    }

}
