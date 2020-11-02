package com.wyn.craftsandbox.back.exposition;

import com.wyn.craftsandbox.back.domain.User;
import com.wyn.craftsandbox.back.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
                Arrays.stream(userRepository.allUsers()).map(this::toDTO).collect(Collectors.toList())
        );
    }

    private UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName());
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserCreationRequest userCreationRequest) {
        return ResponseEntity.ok(
                toDTO(userRepository.addUser(userCreationRequest.getFirstName(), userCreationRequest.getLastName()))
        );
    }

}
