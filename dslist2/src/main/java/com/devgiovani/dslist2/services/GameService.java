package com.devgiovani.dslist2.services;

import com.devgiovani.dslist2.dto.GameMinDTO;
import com.devgiovani.dslist2.entities.Game;
import com.devgiovani.dslist2.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
