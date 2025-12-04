package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;

    @NotNull(message = "Owner email is mandatory")
    @NotEmpty(message = "Owner email must not be empty")
    @Size(min = 1, max = 50, message = "Owner email is is between 1 to 50 chars")
    private String ownerEmail;

    private String phone;

    @NotNull(message = "Password is mandatory")
    @NotEmpty(message = "Password must not be empty")
    private String password;

}
