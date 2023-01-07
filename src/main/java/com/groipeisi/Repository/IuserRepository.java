package com.groipeisi.Repository;

import com.groipeisi.Entite.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IuserRepository extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findByEmail(String email);
}
