package com.groipeisi.Mapping;

import com.groipeisi.Domain.AppUser;
import com.groipeisi.Domain.Ief;
import com.groipeisi.Entite.AppUserEntity;
import com.groipeisi.Entite.IaEntity;
import com.groipeisi.Entite.IefEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IefMapper {
    Ief toIef(IefEntity iefEntity);
    IefEntity fromIef(Ief ief);
}
