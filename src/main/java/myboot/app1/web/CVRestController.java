package myboot.app1.web;

import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.model.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CVRestController {

    @Autowired
    CurriculumeVitaeRepository CR;


    /**
     * Affiche la liste des CVs
     */
    @GetMapping("/cvs")
    public Iterable<CV>  getCVs() {
        return CR.findAll();
    }

    /**
     *
     * @param id
     * @return le cv avec l'id renseigné en param
     */

    @GetMapping("/cv/{id}")
    public CV getCV(@PathVariable int id) {
        return CR.findById(id).get();
    }


    /**
     *
     * @param id
     * @return OK si la suppression de du CV avec l'id indiqué en param est reuissi, sinon NOT FOUND
     */

    @DeleteMapping("/deleteCV/{id}")
    public ResponseEntity<Boolean> deleteCV(@PathVariable (value="id") int id){
        if(CR.existsById(id)){
            CR.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);

        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * Ajoute un nouveau CV
     */

    @PostMapping("/newCV")
    public CV postCV(@RequestBody @Valid CV cv) {
        CR.save(cv);
        return cv;
    }

    /**
     * Mettre à jour un CV
     */

    @PutMapping("/updateCV")
    public ResponseEntity<CV> updateCV (@RequestBody CV cv){

        if(cv.getActivities()==null) throw  new ResponseStatusException(HttpStatus.NO_CONTENT,"Activities missed !");
        else {
            return new ResponseEntity(CR.save(cv), HttpStatus.OK);
        }

    }


}
