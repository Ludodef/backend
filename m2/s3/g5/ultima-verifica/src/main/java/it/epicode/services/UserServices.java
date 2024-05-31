package it.epicode.services;

import it.epicode.entities.User;
import it.epicode.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User savesUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id);
        }else {
            return Optional.empty();
        }
    }
    public User updateUser(User user,Long id){
        var foundedUser = userRepository.findById(id);
        if (foundedUser.isPresent()){
           var definedUser = foundedUser.get();
           return userRepository.save(definedUser.builder()
                   .withEmail(user.getEmail())
                   .withUsername(user.getUsername())
                   .withPassword(user.getPassword())
                   .build());
        }else {
            throw new RuntimeException("Invalid");
        }
    }

    public User delete(Long id){
        var foundedUser = userRepository.findById(id);
        if (foundedUser.isPresent()){
            userRepository.delete(foundedUser.get());
            return foundedUser.get();
        }else {
            throw new RuntimeException("Invalid");
        }
    }
}
