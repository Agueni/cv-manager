package myboot.app1.test;

import myboot.app1.dao.PersonRepository;
import myboot.app1.model.CV;
import myboot.app1.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TestPersonRepository {

    @Autowired
    PersonRepository r;

    @Test

    public void testCreatePerson() {
        var p = r.save(new Person("agueni", "farouk", "farouk@gmail.com", "https://formations.univ-amu.fr/fr/master/5SIN", "06/12/1999", "123",new CV()));
        var p1 = r.findById(p.getId()).get();

        assertEquals(p1.getFirstName(), "agueni");
    }

    @Test
    public void testReadPerson() {
        var p = r.save(new Person("agueni", "farouk", "farouk@gmail.com", "https://formations.univ-amu.fr/fr/master/5SIN", "06/12/1999", "123",new CV()));
        var expected = r.findById(p.getId()).get();

        assertEquals(p.getFirstName(), expected.getFirstName());
    }

    @Test
    public void testUpdatePerson() {
        Person p = new Person("agueni", "farouk", "farouk@gmail.com", "https://formations.univ-amu.fr/fr/master/5SIN", "06/12/1999", "123",new CV());

        r.save(p);
        p.setFirstName("Hallai");
        r.save(p);
        Person expected = r.findById(p.getId()).get();
        assertEquals(p.getFirstName(), expected.getFirstName());
    }

    @Test
    public void testDeletePerson() {
        Person p = new Person("agueni", "farouk", "farouk@gmail.com", "https://formations.univ-amu.fr/fr/master/5SIN", "06/12/1999", "123",new CV());

        r.save(p);
        Person expected = r.save(p);
        assertEquals("agueni", expected.getFirstName());
        r.delete(p);
        assertThrows(NoSuchElementException.class, () -> {
            r.findById(p.getId()).get();
        });

    }
}





