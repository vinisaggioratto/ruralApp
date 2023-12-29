package com.vgs.rural.service;

import com.vgs.rural.dto.RoleDTO;
import com.vgs.rural.entity.Role;
import com.vgs.rural.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<RoleDTO> getAll() {
        return repository.findAll().stream().map(
                role -> new RoleDTO(
                        role.getId(), role.getRole(), role.getIs_active()
                )
        ).collect(Collectors.toList());
    }

    public RoleDTO getById(Long id) {
        Optional<Role> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Role not found.");
        }
        Role role = optional.get();
        return new RoleDTO(
                role.getId(), role.getRole(), role.getIs_active()
        );
    }

    @Transactional
    public RoleDTO save(RoleDTO role){
        Role rolSave = mapper.map(role, Role.class);
        repository.save(rolSave);
        return new RoleDTO(
                role.getId(), role.getRole(), role.getIs_active()
        );
    }

    @Transactional
    public RoleDTO update(RoleDTO role){
        Role rolSave = mapper.map(role, Role.class);
        Optional<Role> optional = repository.findById(role.getId());
        if (!optional.isPresent()){
            throw new RuntimeException("Role not found.");
        }
        repository.save(rolSave);
        return new RoleDTO(
                role.getId(), role.getRole(), role.getIs_active()
        );
    }

    @Transactional
    public void delete(Long id){
        Optional<Role> optional = repository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Role not found.");
        }
        Role role = optional.get();
        role.setIs_active(false);
        repository.save(role);
    }
}
