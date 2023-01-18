package com.PrudentGaming.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PrudentGaming", indexes =@Index(name="idx_game_clientid", columnList="game, clientId"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrudentGamingModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @JsonProperty("numbets")
    private long numbets;

    @Column
    @JsonProperty("game")
    private String game;

    @Column
    @JsonProperty("stake")
    private double stake;

    @Column
    @JsonProperty("returns")
    private float returns;

    @Column
    @JsonProperty("clientid")
    private int clientId;

    @Column
    @JsonProperty("date")
    private String date;
}
