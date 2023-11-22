package com.diplomat.task.service;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserDetailedDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO userDetailDTO);
    List<UserDTO> getAll();
    List<UserDetailedDTO> getAllDetailed();
    Optional<UserDTO> getById(Long id);
    void delete(Long id);
}
