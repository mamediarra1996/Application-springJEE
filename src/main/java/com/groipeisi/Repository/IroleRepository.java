package com.groipeisi.Repository;

import com.groipeisi.Entite.AppRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IroleRepository extends JpaRepository<AppRoleEntity, Integer> {
}
