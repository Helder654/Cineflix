package br.com.cineflix.service;

import br.com.cineflix.entity.User;
import br.com.cineflix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user){
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return repository.save(user);
    }


}
