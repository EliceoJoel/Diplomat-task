package com.diplomat.task.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDetailDTO {
    private Long id;

    @NotNull(message = "User firstname value must not be null")
    @NotBlank(message = "User firstname value must have at least one character")
    @Size(max = 100, message = "User firstname value size supported is maximum 100 characters")
    private String firstName;

    @NotNull(message = "User lastname value must not be null")
    @NotBlank(message = "User lastname value must have at least one character")
    @Size(max = 100, message = "User lastname value size supported is maximum 100 characters")
    private String lastName;

    @Min(value = 1, message = "User age value must have at least 1 as minimum age")
    private Integer age;
    private LocalDate birthday;
}
