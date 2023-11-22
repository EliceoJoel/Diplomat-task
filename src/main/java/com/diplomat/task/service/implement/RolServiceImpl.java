package com.diplomat.task.service.implement;

import com.diplomat.task.dto.RolDTO;
import com.diplomat.task.mapper.RolMapper;
import com.diplomat.task.repository.RolRepository;
import com.diplomat.task.service.RolService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {
        return rolMapper.toDto(rolRepository.save(rolMapper.toEntity(rolDTO)));
    }

    @Override
    public List<RolDTO> getAll() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RolDTO> getById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
}
