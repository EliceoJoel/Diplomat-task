package com.diplomat.task.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_detail_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    private Integer age;

    @Column(columnDefinition = "date")
    private LocalDate birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Valid
    private User user;
}
