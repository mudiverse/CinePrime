package com.cineprime.api.theatre.controller;
import com.cineprime.api.theatre.services.ScreenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineprime.api.dto.ScreenRequest;
import com.cineprime.api.theatre.entity.Screen;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {
    private final ScreenService screenService;

    ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public ResponseEntity<?>createScreenHandler(@RequestBody ScreenRequest screen ){
        return ResponseEntity.ok(screenService.createScreen(screen));
    }

}
