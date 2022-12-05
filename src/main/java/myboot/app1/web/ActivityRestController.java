package myboot.app1.web;

import myboot.app1.dao.ActivityRepository;
import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.model.Activity;
import myboot.app1.model.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class ActivityRestController {

    @Autowired
    ActivityRepository AR;

    @Autowired
    LocalValidatorFactoryBean validationFactory;

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
    public void putActivity(Activity activity) throws Exception {
        Optional<Activity> a = AR.findById(activity.getId());
        if (a.isPresent()){
            AR.save(activity);
        }else {
            throw new Exception("Activity Not Found");
        }


    }
}
