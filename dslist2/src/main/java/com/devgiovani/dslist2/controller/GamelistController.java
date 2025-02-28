package com.devgiovani.dslist2.controller;

import com.devgiovani.dslist2.dto.GameDTO;
import com.devgiovani.dslist2.dto.GameMinDTO;
import com.devgiovani.dslist2.dto.GamelistDTO;
import com.devgiovani.dslist2.dto.ReplacementDTO;
import com.devgiovani.dslist2.services.GameService;
import com.devgiovani.dslist2.services.GamelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GamelistController {

    @Autowired
    private GamelistService gamelistService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GamelistDTO> findAll(){
        List<GamelistDTO> result = gamelistService.findAll();
        return result;

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    @PostMapping (value = "/{listId}/games")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gamelistService.move(listId,body.getSourceIndex(), body.getDestinationIndex());
    }


}
