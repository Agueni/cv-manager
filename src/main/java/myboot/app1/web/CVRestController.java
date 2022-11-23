package myboot.app1.web;

import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.model.Activity;
import myboot.app1.model.CV;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CVRestController {

    @Autowired
    CurriculumeVitaeRepository CR;


    @GetMapping("/CVs")
    public Iterable<CV>  getCVs() {
        return CR.findAll();
    }

    @GetMapping("/CVs/show/{id}")
    public Iterable<Activity>  getCV(@PathVariable int id) {
        return CR.findById(id).get().getActivities();
    }

    @DeleteMapping("/CVs/{id}")
    public void deleteCV(@PathVariable int id) {
        CR.deleteById(id);
    }

    @PostMapping("/CVs")
    public CV postCV(@RequestBody @Valid CV cv) {
        CR.save(cv);
        return cv;
    }

    @PutMapping("/CVs/{id}")
    public void updateCV(@PathVariable int id) {

        CR.deleteById(id);
    }



}
