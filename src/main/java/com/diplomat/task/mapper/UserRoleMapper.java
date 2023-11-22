package com.diplomat.task.mapper;

import com.diplomat.task.dto.UserRolDTO;
import com.diplomat.task.entity.UserRol;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper implements CustomMapper<UserRolDTO, UserRol>{
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO userRolDTO = new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        userRolDTO.setCreatedAt(userRol.getCreatedAt());
        userRolDTO.setUser(userRol.getUser());
        userRolDTO.setRol(userRol.getRol());

        return userRolDTO;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol = new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        userRol.setCreatedAt(userRolDTO.getCreatedAt());
        userRol.setUser(userRolDTO.getUser());
        userRol.setRol(userRolDTO.getRol());

        return userRol;
    }
}
