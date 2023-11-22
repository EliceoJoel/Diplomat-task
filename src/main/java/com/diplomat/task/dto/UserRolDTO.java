package com.diplomat.task.dto;

import com.diplomat.task.entity.Rol;
import com.diplomat.task.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRolDTO {
    private Integer id;

    @NotNull(message = "User Role active value must not be null")
    private Boolean active;

    @NotNull(message = "User Role createdAt value must not be null")
    private LocalDateTime createdAt;
    private User user;
    private Rol rol;
}
