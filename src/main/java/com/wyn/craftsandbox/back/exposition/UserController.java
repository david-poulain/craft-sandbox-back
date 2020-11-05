package com.wyn.craftsandbox.back.exposition;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> users() {
        return ResponseEntity.ok(
                userRepository.allUsers().stream().map(this::toDTO).collect(Collectors.toList())
        );
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserCreationRequest userCreationRequest) {
        User user = new User(
                userRepository.getNextId(),
                userCreationRequest.getFirstName(),
                userCreationRequest.getLastName()
        );
        userRepository.addUser(user);

        return ResponseEntity.ok(toDTO(user));
    }

}
