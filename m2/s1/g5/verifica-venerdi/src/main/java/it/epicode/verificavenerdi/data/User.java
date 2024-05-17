package it.epicode.verificavenerdi.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Builder(setterPrefix = "with")
public class User extends AbClass{


    @Id
    private Integer id;
    private String username;
    @Column(name = "userInformation")
    private String name;
    private String email;
}
