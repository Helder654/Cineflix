package br.com.cineflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cineflix.controller.request.StreamingRequest;
import br.com.cineflix.controller.response.StreamingResponse;
import br.com.cineflix.entity.Streaming;
import br.com.cineflix.mapper.StreamingMapper;
import br.com.cineflix.service.StreamingService;

@RestController 
@RequestMapping("cineflix/streaming")
public class StreamingController {

    private final StreamingService service;

    public StreamingController(StreamingService service) {
        this.service = service;
    }
    
     @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreaming(){
        List<Streaming> streamings = service.findAll();
        List<StreamingResponse> list = streamings.stream()
                .map(Streaming -> StreamingMapper.toStreamingResponse(Streaming))
                .toList();
        return ResponseEntity.ok(list);
    } 

    @PostMapping 
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request){
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = service.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable Long id){
        return service.findById(id)
                .map(Streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(Streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id){
        Optional<Streaming> optStreaming = service.findById(id);
        if(optStreaming.isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
