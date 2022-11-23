package myboot.app1.web;


import myboot.app1.dao.PersonRepository;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {

    @Autowired
    PersonRepository PR;



    @GetMapping("/showAll")
    public Iterable<Person> getPersons() {
        return PR.findAll();
    }

    @GetMapping("/showPerson/{id}")
    public Person getPerson(@PathVariable int id) {
        return PR.findById(id).get();
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable (value="id") int id){
        if(PR.existsById(id)){
            PR.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);

        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/newPerson")
    public Person postPerson(@RequestBody @Valid Person p) {
        PR.save(p);
        return p;
    }

    @PutMapping("/updatePerson")
    public ResponseEntity<Person> updatePerson (@RequestBody Person p){

        if(p.getFirstName()==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Firstname missed !");
        if(p.getLastName()==null)  throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Firstname missed !");
        else {
            return new ResponseEntity(PR.save(p), HttpStatus.OK);
        }

    }








}
