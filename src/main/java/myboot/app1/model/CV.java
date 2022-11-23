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
   @OneToMany(fetch=FetchType.EAGER)
   private List<Activity> activities = new ArrayList<>();





}
