package it.epicode.verificavenerdi.repository;

import it.epicode.verificavenerdi.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(long id);


}
