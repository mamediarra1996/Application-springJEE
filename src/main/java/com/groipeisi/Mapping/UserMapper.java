package com.groipeisi.Mapping;

import com.groipeisi.Domain.AppUser;
import com.groipeisi.Entite.AppUserEntity;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(AppUser appUser);
}
