package com.example.crud.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student lulua = new Student("Lulua" ,
    LocalDate.of(1998,4 , 4),
    "raklalulua@gmail.com");
     Student husein = new Student("Husein" ,
    LocalDate.of(1997,4 , 27),
    "raklalulua@gmail.com");
    repository.saveAll(List.of(lulua , husein));

        };
    }
}
