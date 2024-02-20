package it.be.epicode.EsercizioDue.controllers;


import it.be.epicode.EsercizioDue.entities.User;
import it.be.epicode.EsercizioDue.payloads.usersDto.LoginResponseDTO;
import it.be.epicode.EsercizioDue.payloads.usersDto.NewUserDTO;
import it.be.epicode.EsercizioDue.payloads.usersDto.UserLoginDTO;
import it.be.epicode.EsercizioDue.service.AuthService;
import it.be.epicode.EsercizioDue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserLoginDTO payload) {
        return new LoginResponseDTO(authService.authenticateUserAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUserDTO newUser) {

        return this.usersService.saveUser(newUser);
    }
}