package com.devgiovani.dslist2.entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "tb_game_list")
public class Gamelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Gamelist(){

    }

    public Gamelist(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamelist gamelist = (Gamelist) o;
        return Objects.equals(id, gamelist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
