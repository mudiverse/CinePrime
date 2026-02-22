package com.cineprime.api.theatre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cineprime.api.theatre.entity.Theatre;
import com.cineprime.api.theatre.services.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<?>createTheatreHandler(@RequestBody Theatre theatre){
        return ResponseEntity.ok(theatreService.createTheatre(theatre));
    }

}
