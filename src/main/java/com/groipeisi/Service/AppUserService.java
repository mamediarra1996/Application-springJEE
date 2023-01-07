package com.groipeisi.Service;


import com.groipeisi.Domain.AppUser;
import com.groipeisi.Exception.EntityNotFoundException;
import com.groipeisi.Exception.RequestException;
import com.groipeisi.Mapping.UserMapper;
import com.groipeisi.Repository.IuserRepository;

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
public class AppUserService {
    private IuserRepository iuserRepository;
    private UserMapper userMapper;
    MessageSource messageSource;


    @Transactional(readOnly = true)
    public List<AppUser> getAppUser() {
            return StreamSupport.stream(iuserRepository.findAll().spliterator(),false)
               .map(userMapper::toAppUser)
                    .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppUser getAppUser(int id) {
        return userMapper.toAppUser(iuserRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public AppUser createAppUser(AppUser appUser) {
        return userMapper.toAppUser(iuserRepository.save(userMapper.fromAppUser(appUser)));
    }

    @Transactional
    public AppUser updateAppUser(int id, AppUser appUser){
        return iuserRepository.findById(id)
                .map(entity -> {
                    appUser.setId(id);
                    return userMapper.toAppUser(iuserRepository.save(userMapper.fromAppUser(appUser)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppUser(int id) {
        try {
            iuserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
