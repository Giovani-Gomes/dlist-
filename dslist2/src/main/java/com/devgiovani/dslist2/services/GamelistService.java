package com.devgiovani.dslist2.services;

import com.devgiovani.dslist2.Projection.GameMinProjection;
import com.devgiovani.dslist2.dto.GameMinDTO;
import com.devgiovani.dslist2.dto.GamelistDTO;
import com.devgiovani.dslist2.entities.Game;
import com.devgiovani.dslist2.entities.Gamelist;
import com.devgiovani.dslist2.repositories.GameRepository;
import com.devgiovani.dslist2.repositories.GamelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GamelistService {


    @Autowired
    private GamelistRepository gamelistRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GamelistDTO> findAll(){
        List<Gamelist> result = gamelistRepository.findAll();
        return result.stream().map(x -> new GamelistDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);
        
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i < max; i++) {
            gamelistRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
            
        }
    }
}

