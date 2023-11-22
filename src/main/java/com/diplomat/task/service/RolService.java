package com.diplomat.task.service;

import com.diplomat.task.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    RolDTO save(RolDTO rolDTO);
    List<RolDTO> getAll();
    Optional<RolDTO> getById(Integer id);
    void delete(Integer id);

}
