package com.groipeisi.Controller;

import com.groipeisi.Domain.AppRole;
import com.groipeisi.Domain.AppUser;
import com.groipeisi.Service.AppUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserController {

    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getAppUser() {

        return appUserService.getAppUser();
    }

    @GetMapping("{id}")
    public AppUser getAppUser(@PathVariable("id") int id) {
        return appUserService.getAppUser(id);
        //return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public AppUser createAppUser(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public AppUser updateAppUser(@PathVariable("id") int id, @Valid @RequestBody AppUser appUser) {
        return appUserService.updateAppUser(id, appUser);
    }

    @DeleteMapping("{id}")
    public void deleteAppAppUser(@PathVariable("id") int id) {
        appUserService.deleteAppUser(id);
    }


}
