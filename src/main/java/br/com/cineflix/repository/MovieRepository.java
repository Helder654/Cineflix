package br.com.cineflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cineflix.entity.Category;
import br.com.cineflix.entity.Movie;

@Repository 
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findDistinctByCategories_IdIn(List<Long> categoryIds);

}
