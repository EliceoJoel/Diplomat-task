package com.diplomat.task.service.implement;

import com.diplomat.task.dto.UserDTO;
import com.diplomat.task.dto.UserDetailedDTO;
import com.diplomat.task.entity.Rol;
import com.diplomat.task.entity.User;
import com.diplomat.task.entity.UserDetail;
import com.diplomat.task.entity.UserRol;
import com.diplomat.task.mapper.UserMapper;
import com.diplomat.task.repository.RolRepository;
import com.diplomat.task.repository.UserDetailRepository;
import com.diplomat.task.repository.UserRepository;
import com.diplomat.task.repository.UserRolRepository;
import com.diplomat.task.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailRepository userDetailRepository;
    private final RolRepository rolRepository;
    private final UserRolRepository userRolRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserDetailRepository userDetailRepository, RolRepository rolRepository, UserRolRepository userRolRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userDetailRepository = userDetailRepository;
        this.rolRepository = rolRepository;
        this.userRolRepository = userRolRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User createdUser = userRepository.save(userMapper.toEntity(userDTO));
        if(userDTO.getUserDetail() != null) {
            UserDetail userDetailSent = userDTO.getUserDetail();
            userDetailSent.setUser(createdUser);
            userDetailRepository.save(userDetailSent);
        }
        if(userDTO.getRoles() != null) {
            List<Rol> rolesSent = userDTO.getRoles();
            for(Rol rolSent: rolesSent) {
                UserRol userRol = new UserRol();
                userRol.setActive(true);
                userRol.setCreatedAt(LocalDateTime.now());
                userRol.setUser(createdUser);
                userRol.setRol(rolRepository.save(rolSent));
                userRolRepository.save(userRol);
            }
        }
        return userMapper.toDto(createdUser);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailedDTO> getAllDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDtoDetailed)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        List<UserRol> userRols =  userRolRepository.getUserRolsByUserId(id);
        userRolRepository.deleteAll(userRols);
        userRepository.deleteById(id);
    }
}
