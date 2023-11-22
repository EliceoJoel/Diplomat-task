package com.diplomat.task.dto;

import com.diplomat.task.entity.Rol;
import com.diplomat.task.entity.UserDetail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;

    @NotNull(message = "User username value must not be null")
    @NotBlank(message = "User username value must have at least one character")
    @Size(max = 150, message = "User username value size supported is maximum 150 characters")
    private String username;

    @NotNull(message = "User password value must not be null")
    @Size(min= 6, max = 150, message = "User password value size should have minimum 6 and maximum 100 characters")
    private String password;

    @NotNull(message = "User email value must not be null")
    @Size(max = 150, message = "User email value size supported is maximum 150 characters")
    @Email(message = "User email value must have valid email format")
    private String email;
    private LocalDateTime createdAt;
    private UserDetail userDetail;
    private List<Rol> roles;
}
