package com.groipeisi.Controller;

import com.groipeisi.Domain.AppRole;
import com.groipeisi.Domain.Ief;
import com.groipeisi.Service.IefService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iefs")
@AllArgsConstructor
public class IefController {

    private IefService iefService;

    @GetMapping
    public List<Ief> getIef() {

        return iefService.getIef();
    }

    @GetMapping("{id}")
    public Ief getIef(@PathVariable("id") int id) {
        return iefService.getIef(id);
        //return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Ief createAppRole(@Valid @RequestBody Ief ief) {
        return iefService.createIef(ief);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public Ief updateAppRole(@PathVariable("id") int id, @Valid @RequestBody Ief ief) {
        return iefService.updateIef(id, ief);
    }

    @DeleteMapping("{id}")
    public void deleteIef(@PathVariable("id") int id) {
        iefService.deleteIef(id);
    }


}
