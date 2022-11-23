package myboot.app1.test;


import myboot.app1.dao.ActivityRepository;
import myboot.app1.model.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static myboot.app1.model.Activity.Nature.FORMATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TestActivityRepository {

    @Autowired
    ActivityRepository r;

    @Test
    public void testCreateActivity(){
        var m = r.save(new Activity(2022,FORMATION, "M2 IDL","formation intéresante","https://formations.univ-amu.fr/fr/master/5SIN"));
        var m2 = r.findById(m.getId()).get();

        assertEquals(m2.getTitle(), "M2 IDL");
    }


    @Test
    public void testReadActivity() {
        Activity activity = new Activity(2022,FORMATION, "M2 IDL","formation intéresante","https://formations.univ-amu.fr/fr/master/5SIN");
        r.save(activity);
        Activity expected = r.findById(activity.getId()).get();
        assertEquals(activity.getYear(), expected.getYear());
    }
    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity(2022,FORMATION, "M2 IDL","formation intéresante","https://formations.univ-amu.fr/fr/master/5SIN");
        r.save(activity);
        activity.setYear(2000);
        r.save(activity);
        Activity expected = r.findById(activity.getId()).get();
        assertEquals(activity.getYear(), expected.getYear());
    }

    @Test
    public void testDeleteActivity() {
        Activity activity = new Activity(2022,FORMATION, "M2 IDL","formation intéresante","https://formations.univ-amu.fr/fr/master/5SIN");
        Activity expected = r.save(activity);
        assertEquals(FORMATION, expected.getActivityNature());
        r.delete(activity);
        assertThrows(NoSuchElementException.class,() -> {r.findById(activity.getId()).get();
        });

    }



}
/*
    @Test
    public void testGetActivity() {
        Activity activity = new Activity(2022, ActivityNature.FORMATION, "M2-info", "formation : M2 - IDL", "cv.com");
        activityService.saveActivity(activity);
        Activity expected = activityService.getActivity(activity.getId());
        assertEquals(activity.getYear(), expected.getYear());
    }
}*/
