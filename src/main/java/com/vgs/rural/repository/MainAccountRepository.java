package com.vgs.rural.repository;

import com.vgs.rural.entity.MainAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainAccountRepository extends JpaRepository<MainAccount, Long> {
}
