package com.training.microservices.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.users.User.Role;

@Validated
@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignUpController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signin(@RequestParam String email, @RequestParam String password , @RequestParam Role role) {
        User u = new User(email, passwordEncoder.encode(password), role);
        return repository.save(u);
        //return "User Created Successfully !";
    }

}
