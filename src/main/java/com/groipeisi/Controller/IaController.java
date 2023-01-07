package com.groipeisi.Controller;

import com.groipeisi.Domain.AppUser;
import com.groipeisi.Domain.Ia;
import com.groipeisi.Domain.Ief;
import com.groipeisi.Service.IaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ias")
@AllArgsConstructor
public class IaController {

    private IaService iaService;

    @GetMapping
    public List<Ia> getIa() {

        return iaService.getIa();
    }

    @GetMapping("{id}")
    public Ia getIa(@PathVariable("id") int id) {
        return iaService.getIa(id);
        //return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Ia createIa(@Valid @RequestBody Ia ia) {
        return iaService.createIa(ia);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public Ia updateIa(@PathVariable("id") int id, @Valid @RequestBody Ia ia) {
        return iaService.updateIa(id, ia);
    }

    @DeleteMapping("{id}")
    public void deleteIa(@PathVariable("id") int id) {
        iaService.deleteIa(id);
    }
}
