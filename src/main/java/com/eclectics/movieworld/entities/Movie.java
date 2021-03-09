/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclectics.movieworld.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kiburu
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "recomendation")
    private String recomendation;
    
    @Column(name = "rating")
    private String rating;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "is_watched")
    private boolean isWatched = false;

    public Movie(long id, String title, String description, String recomendation, String rating, String type, boolean isWatched) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.recomendation = recomendation;
        this.rating = rating;
        this.type = type;
        this.isWatched = isWatched;
    }
    
    public Movie(){
    }
    
    public long getId() {
        return id;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsWatched() {
        return isWatched;
    }

    public void setIsWatched(boolean isWatched) {
        this.isWatched = isWatched;
    }
    

}