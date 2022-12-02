package myboot.app1.web;

import myboot.app1.dao.ActivityRepository;
import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.model.Activity;
import myboot.app1.model.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api")
public class ActivityRestController {

    @Autowired
    ActivityRepository AR;


    /**
     * Affiche la liste des activities
     */
    @GetMapping("/activities")
    public Iterable<Activity>  getActivities() {
        return AR.findAll();
    }

    /**
     *
     * @param id
     * @return l'activite avec l'id renseigné en param
     */

    @GetMapping("/activity/{id}")
    public Activity getActivity(@PathVariable int id) {
        return AR.findById(id).get();
    }


    /**
     *
     * @param id
     * @return OK si la suppression de du CV avec l'id indiqué en param est reuissi, sinon NOT FOUND
     */

    @DeleteMapping("/deleteActivity/{id}")
    public ResponseEntity<Boolean> deleteActivity(@PathVariable (value="id") int id){
        if(AR.existsById(id)){
            AR.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);

        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Ajoute une nouvelle activité
     */

    @PostMapping("/newActivity")
    public Activity postActivity(@RequestBody @Valid Activity activity) {
        AR.save(activity);
        return activity;
    }

    /**
     * Mettre à jour une activité
     */

    @PutMapping("/updateActivity")
    public ResponseEntity<Activity> updateActivity (@RequestBody Activity activity){

        if(activity == null) throw  new ResponseStatusException(HttpStatus.NO_CONTENT,"Activities missed !");
        else {
            return new ResponseEntity(AR.save(activity), HttpStatus.OK);
        }

    }
}
