package com.vgs.rural.service;

import com.vgs.rural.dto.MainAccountDTO;
import com.vgs.rural.entity.MainAccount;
import com.vgs.rural.repository.MainAccountRepository;
import com.vgs.rural.viewdto.MainAccountViewDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainAccountService {

    @Autowired
    private MainAccountRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<MainAccountViewDTO> getAll() {
        return repository.findAll().stream().map(
                mainAccount -> new MainAccountViewDTO(
                        mainAccount.getId(), mainAccount.getName(), mainAccount.getCpf_cnpj(),
                        mainAccount.getNum_user_auth(), mainAccount.getActivity_auth(),
                        mainAccount.getIs_active(), mainAccount.getRegister()
                )
        ).collect(Collectors.toList());
    }

    public MainAccountViewDTO getById(Long id) {
        Optional<MainAccount> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Main account not found.");
        }
        MainAccount mainAccount = optional.get();
        return new MainAccountViewDTO(
                mainAccount.getId(), mainAccount.getName(), mainAccount.getCpf_cnpj(),
                mainAccount.getNum_user_auth(), mainAccount.getActivity_auth(),
                mainAccount.getIs_active(), mainAccount.getRegister()
        );
    }

    @Transactional
    public MainAccountViewDTO save(MainAccountDTO mainAccount) {
        MainAccount maiSave = mapper.map(mainAccount, MainAccount.class);
        repository.save(maiSave);
        return new MainAccountViewDTO(
                mainAccount.getId(), mainAccount.getName(), mainAccount.getCpf_cnpj(),
                mainAccount.getNum_user_auth(), mainAccount.getActivity_auth(),
                mainAccount.getIs_active(), mainAccount.getRegister()
        );
    }

    @Transactional
    public MainAccountViewDTO update(MainAccountDTO mainAccount) {
        MainAccount maiSave = mapper.map(mainAccount, MainAccount.class);
        Optional<MainAccount> optional = repository.findById(mainAccount.getId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Main account not found.");
        }
        repository.save(maiSave);
        return new MainAccountViewDTO(
                mainAccount.getId(), mainAccount.getName(), mainAccount.getCpf_cnpj(),
                mainAccount.getNum_user_auth(), mainAccount.getActivity_auth(),
                mainAccount.getIs_active(), mainAccount.getRegister()
        );
    }

    @Transactional
    public void delete(Long id) {
        Optional<MainAccount> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Main account not found.");
        }
        MainAccount mainAccount = optional.get();
        mainAccount.setIs_active(false);
        repository.save(mainAccount);
    }
}
