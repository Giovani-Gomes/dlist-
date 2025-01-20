package com.devgiovani.dslist2.repositories;

import com.devgiovani.dslist2.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
