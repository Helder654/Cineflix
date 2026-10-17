package br.com.cineflix.service;

import br.com.cineflix.entity.User;
import br.com.cineflix.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user){
        return repository.save(user);
    }

}
