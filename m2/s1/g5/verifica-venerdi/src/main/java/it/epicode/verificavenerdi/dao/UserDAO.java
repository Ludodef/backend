package it.epicode.verificavenerdi.dao;

import it.epicode.verificavenerdi.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
