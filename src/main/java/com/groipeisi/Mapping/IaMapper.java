package com.groipeisi.Mapping;

import com.groipeisi.Domain.AppUser;
import com.groipeisi.Domain.Ia;
import com.groipeisi.Entite.AppUserEntity;
import com.groipeisi.Entite.IaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IaMapper {
    Ia toIa(IaEntity iaEntity);
    IaEntity fromIa(Ia ia);
}
