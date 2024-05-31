package it.epicode.controllers;

import it.epicode.entities.User;
import it.epicode.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UserServices userServices;

//    @PostMapping
//    public ResponseEntity<User> saveUser

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        var users = userServices.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<User> getUserById(Long id){
        var foundedUser = userServices.getUserById(id);
        return new ResponseEntity<>(foundedUser.get(), HttpStatus.FOUND);
    }

}
