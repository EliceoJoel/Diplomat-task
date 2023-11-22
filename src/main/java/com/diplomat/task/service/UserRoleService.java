package com.diplomat.task.service;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserRolDTO;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    UserRolDTO save(UserRolDTO userRolDTO);
    List<UserRolDTO> getAll();
    Optional<UserRolDTO> getById(Integer id);
    void delete(Integer id);
    String changeActiveStatus(Integer id);

    List<UserDTO> getUsersByRolId(Integer rolId);
}
