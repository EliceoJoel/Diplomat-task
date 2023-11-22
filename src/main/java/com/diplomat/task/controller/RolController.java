package com.diplomat.task.controller;

import com.diplomat.task.dto.RolDTO;
import com.diplomat.task.service.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAllRoles() {
        return ResponseEntity.ok().body(rolService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(rolService.getById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found for role with id: " + id)));
    }

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@Valid @RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Id attribute must not be sent");
        }

        RolDTO savedRolDTO = rolService.save(dto);
        return ResponseEntity.created(new URI("/api/v1/rol" + savedRolDTO.getId())).body(savedRolDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> updateRol(@Valid @RequestBody final RolDTO dto, @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid rol id sent in body. Value should not be null");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid rol id. Path variable rol id and body rol id does not match");
        }

        return ResponseEntity.ok().body(this.rolService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Integer id) {
        rolService.delete(id);
        return ResponseEntity.ok().body("Rol deleted successfully for id: " + id);
    }
}
