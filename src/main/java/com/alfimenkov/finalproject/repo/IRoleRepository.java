package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {

    Role findRoleById(Long id);

    void deleteRoleById(Long id);

}
