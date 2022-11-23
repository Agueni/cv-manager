package myboot.app1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Activity {

    public enum Nature {

        EXPERIENCEPROFESSIONNELLE,
        FORMATION,
        PROJETS,
        AUTRE

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column
    int year;

    @Basic
    @Column
    Nature activityNature;

    @Basic
    @Column
    String title;

    @Basic
    @Column
    String description;

    @Basic
    @Column
    String webSite;


    public Activity(int year, Nature activityNature, String title, String description, String webSite) {
        this.year = year;
        this.activityNature = activityNature;
        this.title = title;
        this.description = description;
        this.webSite = webSite;
    }


    /*  public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }*/

}