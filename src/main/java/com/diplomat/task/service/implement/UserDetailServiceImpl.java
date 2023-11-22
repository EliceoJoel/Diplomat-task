package com.diplomat.task.service.implement;

import com.diplomat.task.dto.UserDetailDTO;
import com.diplomat.task.mapper.UserDetailMapper;
import com.diplomat.task.repository.UserDetailRepository;
import com.diplomat.task.service.UserDetailService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    public UserDetailDTO save(UserDetailDTO userDetailDTO) {
        return userDetailMapper.toDto(userDetailRepository.save(userDetailMapper.toEntity(userDetailDTO)));
    }

    @Override
    public List<UserDetailDTO> getAll() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDetailDTO> getById(Long id) {
        return userDetailRepository.findById(id).map(userDetailMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        userDetailRepository.deleteById(id);
    }
}
