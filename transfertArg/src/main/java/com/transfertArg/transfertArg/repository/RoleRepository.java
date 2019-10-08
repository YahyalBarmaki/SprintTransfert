package com.transfertArg.transfertArg.repository;


import com.transfertArg.transfertArg.model.Role;
import com.transfertArg.transfertArg.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
