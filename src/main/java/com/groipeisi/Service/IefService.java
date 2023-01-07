package com.groipeisi.Service;


import com.groipeisi.Domain.Ief;

import com.groipeisi.Exception.EntityNotFoundException;
import com.groipeisi.Exception.RequestException;
import com.groipeisi.Mapping.IefMapper;
import com.groipeisi.Repository.IiefRepository;

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
public class IefService {
    private IiefRepository iiefRepository;
    private IefMapper iefMapper;
    MessageSource messageSource;


    @Transactional(readOnly = true)
    public List<Ief> getIef() {
            return StreamSupport.stream(iiefRepository.findAll().spliterator(),false)
               .map(iefMapper::toIef)
                    .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Ief getIef(int id) {
        return iefMapper.toIef(iiefRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("ief.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Ief createIef(Ief ief) {
        return iefMapper.toIef(iiefRepository.save(iefMapper.fromIef(ief)));
    }

    @Transactional
    public Ief updateIef(int id, Ief ief){
        return iiefRepository.findById(id)
                .map(entity -> {
                    ief.setId(id);
                    return iefMapper.toIef(iiefRepository.save(iefMapper.fromIef(ief)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteIef(int id) {
        try {
            iiefRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("ief.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
