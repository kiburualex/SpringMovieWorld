/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclectics.movieworld.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kiburu
 */
@RestController
@RequestMapping("movies/")
@CrossOrigin
public class MoviesController {
    
    // Available to all users
    @GetMapping("test/")
    public String test1(){
        return "API Test";
    }
    
}
