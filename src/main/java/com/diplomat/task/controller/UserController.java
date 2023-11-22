package com.diplomat.task.controller;

import com.diplomat.task.dto.RolDTO;
import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(userService.getAllDetailed());
        } else {
            return ResponseEntity.ok().body(userService.getAll());
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }
        dto.setCreatedAt(LocalDateTime.now());
        UserDTO createdUserDTO = userService.save(dto);

        return ResponseEntity.created(new URI("/api/v1/user/" + createdUserDTO.getId())).body(createdUserDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody final UserDTO dto, @PathVariable final Long id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id sent in body. Value should not be null");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid user id. Path variable user id and body rol id does not match");
        }

        return ResponseEntity.ok().body(this.userService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Long id) {
        userService.delete(id);
        return ResponseEntity.ok().body("User deleted successfully for id: " + id);
    }

}
