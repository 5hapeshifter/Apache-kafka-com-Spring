package br.com.springkafkaproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    private final String topicName;

    // Estamos fazendo a injecao de dependencias com @Value informando o valor da propriedade
    public KafkaTopicConfiguration(@Value(value = "${topic.name}")String topicName) {
        this.topicName = topicName;
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(    "people", 1, (short) 1);
    }
}
