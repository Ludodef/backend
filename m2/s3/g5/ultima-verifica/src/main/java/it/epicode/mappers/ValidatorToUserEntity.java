package it.epicode.mappers;

import it.epicode.entities.User;
import it.epicode.validation.UserValidator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ValidatorToUserEntity {


        public User toUserEntity(UserValidator v) {
            User user = User.builder()
                    .withEmail(v.email())
                    .withPassword(v.password())
                    .withUsername(v.username())
                    .withRoles(v.roles())
                    .build();
            return user;
        }

    }

