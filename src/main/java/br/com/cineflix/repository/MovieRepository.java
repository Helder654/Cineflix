package br.com.cineflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cineflix.entity.Movie;

@Repository 
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
