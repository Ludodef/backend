package it.epicode.controllers;

import it.epicode.entities.User;
import it.epicode.logRegService.UserLogReg;
import it.epicode.mappers.ValidatorToUserEntity;
import it.epicode.services.UserServices;
import it.epicode.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UserServices userServices;
    @Autowired
    ValidatorToUserEntity mapper;
    @Autowired
    UserLogReg logReg;
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody @Validated UserValidator userValid,
                                      BindingResult validation,
                                      UriComponentBuilder uri){
        if(validation.hasErrors()){
            throw  new RuntimeException("User validation failed");
        }
        var newUser = logReg.register(User.builder()
                .withEmail(userValid.email())
                .withUsername(userValid.username())
                .withPassword(userValid.password())
                .withRoles(userValid.roles())
                .build());

        var headers = new HttpHeaders();

        headers.add("Location",uri.path("/api/users/{id}").buildAndExpand(newUser.getId()).toString());

        return new ResponseEntity<>(newUser,headers, HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        var users = userServices.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        var foundedUser = userServices.getUserById(id);
        return new ResponseEntity<>(foundedUser.get(), HttpStatus.FOUND);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Validated UserValidator userValidator, BindingResult validator, @PathVariable Long id){
        if(validator.hasErrors()){
            throw  new RuntimeException("User validation failed");
        }else{
            var newUser = userServices.updateUser(mapper.toUserEntity(userValidator),id);
            return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){

        var user=userServices.delete(id);

        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }


}
