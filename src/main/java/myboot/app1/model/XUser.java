package myboot.app1.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.*;
import myboot.app1.dao.XUserRepository;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class XUser {

    @Id
    String userName;

    @Basic
    String password;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<String> roles;

}