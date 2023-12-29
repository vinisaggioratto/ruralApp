package com.vgs.rural.service;

import com.vgs.rural.dto.RegisterDTO;
import com.vgs.rural.entity.Register;
import com.vgs.rural.repository.RegisterRepository;
import com.vgs.rural.viewdto.RegisterViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<RegisterViewDTO> getAll() {
        return repository.findAll().stream().map(
                register -> new RegisterViewDTO(
                        register.getId(), register.getName(), register.getCpf_cnpj(),
                        register.getEmail(), register.getIs_active(), register.getType_register()
                )
        ).collect(Collectors.toList());
    }

    public RegisterViewDTO getById(Long id) {
        Optional<Register> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        Register register = optional.get();
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getIs_active(), register.getType_register()
        );
    }

    @Transactional
    public RegisterViewDTO save(RegisterDTO register) {
        Register regSave = mapper.map(register, Register.class);
        repository.save(regSave);
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getIs_active(), register.getType_register()
        );
    }

    @Transactional
    public RegisterViewDTO update(RegisterDTO register) {
        Register regSave = mapper.map(register, Register.class);
        Optional<Register> optional = repository.findById(register.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        repository.save(regSave);
        return new RegisterViewDTO(
                register.getId(), register.getName(), register.getCpf_cnpj(),
                register.getEmail(), register.getIs_active(), register.getType_register()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<Register> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Register not found.");
        }
        Register register = optional.get();
        register.setIs_active(false);
        repository.save(register);
    }
}
