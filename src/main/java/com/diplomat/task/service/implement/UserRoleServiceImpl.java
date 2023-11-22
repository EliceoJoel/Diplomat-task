package com.diplomat.task.service.implement;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserRolDTO;
import com.diplomat.task.entity.User;
import com.diplomat.task.entity.UserRol;
import com.diplomat.task.mapper.UserMapper;
import com.diplomat.task.mapper.UserRoleMapper;
import com.diplomat.task.repository.UserRolRepository;
import com.diplomat.task.service.UserRoleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRolRepository userRolRepository;
    private final UserRoleMapper userRoleMapper;
    private final UserMapper userMapper;

    public UserRoleServiceImpl(UserRolRepository userRolRepository, UserRoleMapper userRoleMapper, UserMapper userMapper) {
        this.userRolRepository = userRolRepository;
        this.userRoleMapper = userRoleMapper;
        this.userMapper = userMapper;
    }

    @Override
    public UserRolDTO save(UserRolDTO userRolDTO) {
        return userRoleMapper.toDto(userRolRepository.save(userRoleMapper.toEntity(userRolDTO)));
    }

    @Override
    public List<UserRolDTO> getAll() {
        return userRolRepository.findAll()
                .stream()
                .map(userRoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRolDTO> getById(Integer id) {
        return userRolRepository.findById(id).map(userRoleMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        userRolRepository.deleteById(id);
    }

    @Override
    public String changeActiveStatus(Integer id) {
        Optional<UserRolDTO> userRolDTOOptional = userRolRepository.findById(id).map(userRoleMapper::toDto);
        if(userRolDTOOptional.isPresent()) {
            UserRolDTO userRolDTO = userRolDTOOptional.get();
            userRolDTO.setActive(!userRolDTO.getActive());
            userRolRepository.save(userRoleMapper.toEntity(userRolDTO));
            return "Active status changed successfully!";
        } else {
            return "user-rol with ID " + id + " does not exist" ;
        }
    }

    @Override
    public List<UserDTO> getUsersByRolId(Integer rolId) {
        List<UserRol> userRols = userRolRepository.getUserRolsByRol_Id(rolId);
        List<User> users = new ArrayList<>();
        for(UserRol userRol : userRols) {
            users.add(userRol.getUser());
        }
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
