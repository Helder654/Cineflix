package br.com.cineflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cineflix.entity.Streaming;

@Repository 
public interface StreamingRepository extends JpaRepository<Streaming, Long> {

}
