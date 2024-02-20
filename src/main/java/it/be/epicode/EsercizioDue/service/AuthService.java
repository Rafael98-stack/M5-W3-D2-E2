package it.be.epicode.EsercizioDue.service;


import it.be.epicode.EsercizioDue.entities.User;
import it.be.epicode.EsercizioDue.exceptions.UnauthorizedException;
import it.be.epicode.EsercizioDue.payloads.usersDto.UserLoginDTO;
import it.be.epicode.EsercizioDue.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersService usersService;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUserAndGenerateToken(UserLoginDTO payload) {
        User user = usersService.findByEmail(payload.email());
        if (user.getPassword().equals(payload.password())) {

            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Credenziali sbagliate!");
        }


    }
}
