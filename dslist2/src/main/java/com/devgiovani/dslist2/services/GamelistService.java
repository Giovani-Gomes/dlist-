package com.devgiovani.dslist2.services;

import com.devgiovani.dslist2.dto.GameMinDTO;
import com.devgiovani.dslist2.dto.GamelistDTO;
import com.devgiovani.dslist2.entities.Game;
import com.devgiovani.dslist2.entities.Gamelist;
import com.devgiovani.dslist2.repositories.GamelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GamelistService {


    @Autowired
    private GamelistRepository gamelistRepository;


    @Transactional(readOnly = true)
    public List<GamelistDTO> findAll(){
        List<Gamelist> result = gamelistRepository.findAll();
        return result.stream().map(x -> new GamelistDTO(x)).toList();
    }
}
