package com.groipeisi.Controller;

import com.groipeisi.Domain.AppRole;
import com.groipeisi.Service.AppRoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRoleController {
    private AppRoleService appRoleService;

    @GetMapping
    public List<AppRole> getAppRole() {

        return appRoleService.getAppRole();
    }

    @GetMapping("{id}")
    public AppRole getAppRole(@PathVariable("id") int id) {
        return appRoleService.getAppRole(id);
        //return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public AppRole createAppRole(@Valid @RequestBody AppRole appRole) {
        return appRoleService.createAppRole(appRole);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public AppRole updateAppRole(@PathVariable("id") int id, @Valid @RequestBody AppRole appRole) {
        return appRoleService.updateAppRole(id, appRole);
    }

    @DeleteMapping("{id}")
    public void deleteAppRole(@PathVariable("id") int id) {
        appRoleService.deleteAppRole(id);
    }


}
