package it.be.epicode.EsercizioDue.payloads.usersDto;

public record NewUserDTO
        (String name,
        String surname,
        String email,
        String password) {
}
