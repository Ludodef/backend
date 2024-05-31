package it.epicode.logRegService;

import it.epicode.entities.User;
import it.epicode.repositories.RoleRepository;
import it.epicode.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLogReg {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    AuthenticationManager authenticationManager;

//    @Autowired
//    JwtU

    public User register(User user) {
        try {
            var p = encoder.encode(user.getPassword());
            user.setPassword(p);
            return userRepo.save(user);
        } catch (Exception e) {
            throw new RuntimeException("no");
        }
    }
}
