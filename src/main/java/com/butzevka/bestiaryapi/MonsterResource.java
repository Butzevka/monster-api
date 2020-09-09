package com.butzevka.bestiaryapi;

import com.butzevka.bestiaryapi.monsters.Monster;
import com.butzevka.bestiaryapi.repositories.MonsterRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MonsterResource {

    private final MonsterRepository monsterRepository;

    @GetMapping("/chuck-fact")
    public String chuckFact() {
        Faker faker = new Faker();
        return faker.chuckNorris().fact();
    }

    @GetMapping("/monster/{id}")
    public ResponseEntity<Monster> getMonster(@PathVariable Long id) {
        Optional<Monster> monster = monsterRepository.findById(id);
        return monster.map(h->new ResponseEntity<>(h, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
