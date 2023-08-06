package com.nci.webapp.ASDInsights.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int date;
    private String name;
    private int DayRating;
    private int socialInteraction;
    private int anxiety;
    private int pleasant;
    private int impatience;
    private int friendliness;
    private int communication;
    private int concentration;
    private String happy;
    private String good;
    private String calm;
    private String upset;
    private String annoyed;
    private String angry;
















}
