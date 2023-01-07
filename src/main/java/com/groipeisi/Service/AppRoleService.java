package com.groipeisi.Service;

import com.groipeisi.Domain.AppRole;
import com.groipeisi.Exception.EntityNotFoundException;
import com.groipeisi.Exception.RequestException;
import com.groipeisi.Mapping.RoleMapper;
import com.groipeisi.Repository.IroleRepository;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppRoleService {
    private IroleRepository iroleRepository;
    private RoleMapper roleMapper;

    MessageSource messageSource;

   @Transactional(readOnly = true)
   public List<AppRole> getAppRole() {
       return StreamSupport.stream(iroleRepository.findAll().spliterator(), false)
               .map(roleMapper::toAppRole)
               .collect(Collectors.toList());
   }

    @Transactional
    public AppRole getAppRole(int id) {
        return roleMapper.toAppRole(iroleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public AppRole createAppRole(AppRole appRole) {
        return roleMapper.toAppRole(iroleRepository.save(roleMapper.fromAppRole(appRole)));
    }

    @Transactional
    public AppRole updateAppRole(int id, AppRole appRole){
        return iroleRepository.findById(id)
                .map(entity -> {
                    appRole.setId(id);
                    return roleMapper.toAppRole(iroleRepository.save(roleMapper.fromAppRole(appRole)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRole(int id) {
        try {
            iroleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
