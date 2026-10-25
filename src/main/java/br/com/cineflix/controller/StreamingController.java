package br.com.cineflix.controller;

import br.com.cineflix.controller.request.StreamingRequest;
import br.com.cineflix.controller.response.StreamingResponse;
import br.com.cineflix.entity.Streaming;
import br.com.cineflix.mapper.StreamingMapper;
import br.com.cineflix.service.StreamingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("cineflix/streaming")
@Tag(name = "Streaming", description = "Recurso responsavel pelo gerenciamento dos servicos de streamings.")
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
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request){
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
