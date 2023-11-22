package com.diplomat.task.service;

import com.diplomat.task.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    UserDetailDTO save(UserDetailDTO userDetailDTO);
    List<UserDetailDTO> getAll();
    Optional<UserDetailDTO> getById(Long id);
    void delete(Long id);
}
