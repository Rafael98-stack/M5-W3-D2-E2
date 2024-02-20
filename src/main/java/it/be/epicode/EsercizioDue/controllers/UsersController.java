package it.be.epicode.EsercizioDue.controllers;



/* -------------------------------------------------------- USERS CRUD -----------------------------------------------

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ body)
3. GET http://localhost:3001/users/{id}
4. PUT http://localhost:3001/users/{id} (+ body)
5. DELETE http://localhost:3001/users/{id}

*/

import it.be.epicode.EsercizioDue.entities.User;
import it.be.epicode.EsercizioDue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String orderBy
    ) {
        return this.usersService.getUsers(page, size, orderBy);
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable UUID id) {
        return this.usersService.findById(id);
    }



    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User findByIdAndUpdate(@PathVariable UUID id, @RequestBody User updatedUser) {

        return this.usersService.findByIdAndUpdate(id, updatedUser);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id) {
        this.usersService.findByIdAndDelete(id);
    }

}
