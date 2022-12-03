package myboot.app1.web;


import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.dao.PersonRepository;
import myboot.app1.model.CV;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    PersonRepository PR;

    @Autowired
    CurriculumeVitaeRepository CR;


    /**
     *
     * @return la liste des personnes
     */

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return PR.findAll();
    }

    /**
     *
     * @param id
     * @return la personnes dont l'id est en parametre
     */

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable int id) {
        return PR.findById(id).get();
    }

    /**
     *
     * @param id
     * @return OK si la suppression de la personne avec l'id indiqué en parametre est reuissi, sinon NOT FOUND
     */

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

    /**
     * Ajoute une nouvelle personne
     */

    @PostMapping("/newPerson")
    public String postPerson(@RequestBody @Valid Person p) {
        PR.save(p);
        CV cv = new CV();
        cv.setPerson(p);
        CR.save(cv);

        return "redirect:/persons";
    }


    /**
     *mettre à jour les coordonnées d'une personne
     */

    @PutMapping("/updatePerson")
    public ResponseEntity<Person> updatePerson (@RequestBody @Valid Person p){

        if(p.getFirstName()==null) throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Firstname missed !");
        if(p.getLastName()==null)  throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Lastname missed !");
        else {
            return new ResponseEntity(PR.save(p), HttpStatus.OK);
        }

    }








}
