package io.d1av.blog.repository;

import io.d1av.blog.entity.Role;
import io.d1av.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
