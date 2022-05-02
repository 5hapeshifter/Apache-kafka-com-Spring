package br.com.springkafka.producer;


import br.com.springkafka.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeopleProducer {

    private final String topicName;
    private final KafkaTemplate<String, People> kafkaTemplate;// Aqui temos que utilizar as classes People geradas pelo maven, com base no Avro

    public PeopleProducer(@Value("${topic.name}") String topicName, KafkaTemplate<String, People> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(People people) {
        kafkaTemplate.send(topicName, people).addCallback(
                success -> log.info("Mensagem enviada com sucesso para o topico = " + topicName),
                failure -> log.info("Falha ao enviar a mensagem para o topico = " + topicName)
        );
    }
}
