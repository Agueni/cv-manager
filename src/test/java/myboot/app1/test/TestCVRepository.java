package myboot.app1.test;


import myboot.app1.dao.ActivityRepository;
import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.model.Activity;
import myboot.app1.model.CV;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static myboot.app1.model.Activity.Nature.EXPERIENCEPROFESSIONNELLE;
import static myboot.app1.model.Activity.Nature.PROJETS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@SpringBootTest
public class TestCVRepository {

    @Autowired
    CurriculumeVitaeRepository cvRepo;

    @Autowired
    ActivityRepository actRepo;

    @Test
    public void testCreateCV(){


        CV cv = new CV();
        var m = cvRepo.save(cv);
        var m2 = cvRepo.findById(m.getId());

        assertEquals(m2.get().getId(),cv.getId());
    }

    @Test
    public void testReadCV(){

        Activity activity = new Activity(2018,EXPERIENCEPROFESSIONNELLE, "Babysitter"," "," ");
        actRepo.save(activity);
        List<Activity> activities = new ArrayList<>();
        activities.add(activity);
        CV cv= new CV();
        var m = cvRepo.save(cv);
        cv.setActivities(activities);
        var m2 = cvRepo.findById(cv.getId()).get();
        assertEquals(m2.getActivities().get(0).getTitle(),"Babysitter");
    }

    @Test
    public void testUpdateCV() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(2021,PROJETS, "JEE/SPRING"," "," "));

        CV cv = new CV();
        cvRepo.save(cv);
        cv.setActivities(activities);
        cvRepo.save(cv);
        var m = cvRepo.findById(cv.getId()).get();
        assertEquals(m.getActivities(),activities);
    }


    @Test
    public void testDeleteCV() {
        CV cv = new CV();
        var m = cvRepo.save(cv);
        var m2 = cvRepo.findById(m.getId()).get();

        assertEquals(m2.getId(),cv.getId());
        cvRepo.delete(cv);
        assertThrows(NoSuchElementException.class, () -> {cvRepo.findById(cv.getId()).get();});

    }

}
