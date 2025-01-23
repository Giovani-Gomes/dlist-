package com.devgiovani.dslist2.repositories;

import com.devgiovani.dslist2.entities.Game;
import com.devgiovani.dslist2.entities.Gamelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GamelistRepository extends JpaRepository<Gamelist, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
