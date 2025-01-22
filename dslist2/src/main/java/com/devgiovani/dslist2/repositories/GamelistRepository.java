package com.devgiovani.dslist2.repositories;

import com.devgiovani.dslist2.entities.Game;
import com.devgiovani.dslist2.entities.Gamelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamelistRepository extends JpaRepository<Gamelist, Long> {
}
