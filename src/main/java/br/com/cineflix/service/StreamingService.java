package br.com.cineflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cineflix.entity.Streaming;
import br.com.cineflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;

@Service 
public class StreamingService {

    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> findAll(){
        return repository.findAll();
    }

    public Streaming saveStreaming(Streaming streaming){
        return repository.save(streaming);
    }
    
    public Optional<Streaming> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
