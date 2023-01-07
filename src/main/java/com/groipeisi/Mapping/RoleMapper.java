package com.groipeisi.Mapping;

import com.groipeisi.Domain.AppRole;
import com.groipeisi.Entite.AppRoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    AppRole toAppRole(AppRoleEntity appRoleEntity);
    AppRoleEntity fromAppRole(AppRole appRole);
}
