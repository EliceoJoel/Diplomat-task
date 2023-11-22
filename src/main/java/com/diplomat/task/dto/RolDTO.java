package com.diplomat.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RolDTO {
    private Integer id;

    @NotNull(message = "Role name value must not be null")
    @NotBlank(message = "Role name value must have at least one character")
    @Size(max = 100, message = "Role name value size supported is maximum 100 characters")
    private String name;
}
