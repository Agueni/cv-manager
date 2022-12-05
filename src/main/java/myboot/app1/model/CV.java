package myboot.app1.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


   //@ElementCollection(fetch = FetchType.EAGER)
   @OneToMany(fetch=FetchType.LAZY)
   private List<Activity> activities = new ArrayList<>();

    @OneToOne(targetEntity=Person.class)
    @JoinColumn(name="person_cv")
    Person person;

    public CV(List<Activity> activities, Person person) {

        this.activities = activities;
        this.person=person;
    }

}
