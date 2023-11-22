package com.diplomat.task.controller;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserRolDTO;
import com.diplomat.task.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-rol")
public class UserRolController {
    private final UserRoleService userRoleService;

    public UserRolController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> changeActiveStatus(@PathVariable final Integer id) {
        return ResponseEntity.ok().body(userRoleService.changeActiveStatus(id));
    }

    @GetMapping("/users/rol/{rolId}")
    public ResponseEntity<List<UserDTO>> getUserByRolId(@PathVariable final Integer rolId) {
        return ResponseEntity.ok().body(userRoleService.getUsersByRolId(rolId));
    }
}
