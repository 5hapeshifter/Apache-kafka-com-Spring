package br.com.springkafka.consumer;

import br.com.springkafka.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeopleConsumer {

    // Estamos consumindo o objeto gerado com base no Avro
    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, People> consumerRecord, Acknowledgment ack) { // O Acknowledgment serve para marcarmos a msg como lida
        var people = consumerRecord.value();
        log.info("Mensagem recebida = " + people.toString());
        ack.acknowledge();
    }
}
