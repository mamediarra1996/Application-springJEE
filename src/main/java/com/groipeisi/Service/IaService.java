package com.groipeisi.Service;


import com.groipeisi.Domain.Ia;
import com.groipeisi.Exception.EntityNotFoundException;
import com.groipeisi.Exception.RequestException;
import com.groipeisi.Mapping.IaMapper;
import com.groipeisi.Repository.IiaRepository;

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
public class IaService {
    private IiaRepository iiaRepository;
    private IaMapper iaMapper;
    MessageSource messageSource;


    @Transactional(readOnly = true)
    public List<Ia> getIa() {
            return StreamSupport.stream(iiaRepository.findAll().spliterator(),false)
               .map(iaMapper::toIa)
                    .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Ia getIa(int id) {
        return iaMapper.toIa(iiaRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("ia.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Ia createIa(Ia ia) {
        return iaMapper.toIa(iiaRepository.save(iaMapper.fromIa(ia)));
    }

    @Transactional
    public Ia updateIa(int id, Ia ia){
        return iiaRepository.findById(id)
                .map(entity -> {
                    ia.setId(id);
                    return iaMapper.toIa(iiaRepository.save(iaMapper.fromIa(ia)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("ia.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteIa(int id) {
        try {
            iiaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("ia.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
