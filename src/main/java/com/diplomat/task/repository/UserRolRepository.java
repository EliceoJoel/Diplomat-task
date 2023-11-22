package com.diplomat.task.repository;

import com.diplomat.task.entity.User;
import com.diplomat.task.entity.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {
    List<UserRol> getUserRolsByUserId(Long id);
    List<UserRol> getUserRolsByRol_Id(Integer id);
}
