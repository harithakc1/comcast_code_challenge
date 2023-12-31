package org.src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.src.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
