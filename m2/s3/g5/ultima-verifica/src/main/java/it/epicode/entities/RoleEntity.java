package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor


public class RoleEntity extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "users")
    private final List<User> users = new ArrayList<>();

}
