package com.butzevka.bestiaryapi;

import com.butzevka.bestiaryapi.monsters.Monster;
import com.butzevka.bestiaryapi.repositories.MonsterRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class BestiaryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestiaryApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MonsterRepository monsterRepository) {
        Faker faker = new Faker();
        return args -> IntStream.range(0,100).forEach(i->monsterRepository.save(new Monster(faker.elderScrolls().creature())));
    }
}
