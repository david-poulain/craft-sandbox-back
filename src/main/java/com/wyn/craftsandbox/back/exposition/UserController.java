package com.wyn.craftsandbox.back.exposition;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @GetMapping
    public ResponseEntity<List<UserDTO>> users() {
        return ResponseEntity.ok(
                Collections.singletonList(
                        new UserDTO("Chuck", "Norris")
                )
        );
    }
}
