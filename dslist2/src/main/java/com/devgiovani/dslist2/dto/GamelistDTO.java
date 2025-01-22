package com.devgiovani.dslist2.dto;

import com.devgiovani.dslist2.entities.Gamelist;

public class GamelistDTO {

    private Long id;
    private String name;

    GamelistDTO(){}

    public GamelistDTO(Gamelist entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
