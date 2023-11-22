package com.diplomat.task.mapper;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserDetailedDTO;
import com.diplomat.task.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User>{
    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedAt(user.getCreatedAt());

        return userDTO;
    }

    public UserDetailedDTO toDtoDetailed(User user) {
        UserDetailedDTO userDetailedDTO = new UserDetailedDTO();
        userDetailedDTO.setId(user.getId());
        userDetailedDTO.setUsername(user.getUsername());
        userDetailedDTO.setEmail(user.getEmail());
        userDetailedDTO.setPassword(user.getPassword());
        userDetailedDTO.setCreatedAt(user.getCreatedAt());
        if(user.getUserDetail() != null) {
            userDetailedDTO.setFirstName(user.getUserDetail().getFirstName());
            userDetailedDTO.setLastName(user.getUserDetail().getLastName());
            userDetailedDTO.setAge(user.getUserDetail().getAge());
            userDetailedDTO.setBirthday(user.getUserDetail().getBirthday());
        }
        return userDetailedDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}
