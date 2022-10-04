package com.akturkpasaj.User.Management.System.repository;

import com.akturkpasaj.User.Management.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String username);

}
