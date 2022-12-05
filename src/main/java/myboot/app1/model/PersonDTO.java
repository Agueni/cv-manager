package myboot.app1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String email;
    private String password;
    Set<String> roles;

}