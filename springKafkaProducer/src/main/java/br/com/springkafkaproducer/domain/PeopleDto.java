package br.com.springkafkaproducer.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class PeopleDto {

    private String name;
    private String cpf;
    private List<String> books;
}
