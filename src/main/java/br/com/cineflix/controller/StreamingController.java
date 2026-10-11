package br.com.cineflix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineflix.service.StreamingService;

@RestController 
@RequestMapping("cineflix/streaming")
public class StreamingController {

    private final StreamingService service;

    public StreamingController(StreamingService service) {
        this.service = service;
    }
    
}
