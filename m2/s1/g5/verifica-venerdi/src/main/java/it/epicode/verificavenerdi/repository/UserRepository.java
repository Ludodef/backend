package it.epicode.verificavenerdi.repository;

import it.epicode.verificavenerdi.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
