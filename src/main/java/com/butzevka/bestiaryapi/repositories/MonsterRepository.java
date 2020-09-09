package com.butzevka.bestiaryapi.repositories;

import com.butzevka.bestiaryapi.monsters.Monster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
