package com.vgs.rural.service;

import com.vgs.rural.dto.UserDTO;
import com.vgs.rural.entity.User;
import com.vgs.rural.repository.UserRepository;
import com.vgs.rural.viewdto.UserViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<UserViewDTO> getAll() {
        return repository.findAll().stream().map(
                user -> new UserViewDTO(
                        user.getId(), user.getName(), user.getLogin(),
                        user.getIs_active(), user.getRegister().getName(), user.getRole().getRole()
                )
        ).collect(Collectors.toList());
    }

    public UserViewDTO getById(Long id) {
        User user = repository.findById(id).orElseThrow();

        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(),
                user.getIs_active(), user.getRegister().getName(), user.getRole().getRole()
        );
    }

    @Transactional
    public UserViewDTO save(UserDTO user) {
        User useSave = mapper.map(user, User.class);
        repository.save(useSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(),
                user.getIs_active(), user.getRegister().getName(), user.getRole().getRole()
        );
    }

    @Transactional
    public UserViewDTO update(UserDTO user) {
        User useSave = mapper.map(user, User.class);
        Optional<User> optional = repository.findById(user.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Users not found.");
        }
        repository.save(useSave);
        return new UserViewDTO(
                user.getId(), user.getName(), user.getLogin(),
                user.getIs_active(), user.getRegister().getName(), user.getRole().getRole()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<User> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Users not found.");
        }
        User useSave = optional.get();
        useSave.setIs_active(false);
        repository.save(useSave);
    }


}
