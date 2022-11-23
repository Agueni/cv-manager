package myboot.app1.web;


import myboot.app1.dao.PersonRepository;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    PersonRepository PR;


    @GetMapping("/persons")
    public Iterable<Person>  getPersons() {
        return PR.findAll();
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable int id) {
        return PR.findById(id).get();
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable int id) {
        PR.deleteById(id);
    }

    @PostMapping("/persons")
    public Person postPerson(@RequestBody @Valid Person p) {
        PR.save(p);
        return p;
    }






}
