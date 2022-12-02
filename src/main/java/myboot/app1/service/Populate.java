package myboot.app1.service;


import myboot.app1.dao.ActivityRepository;
import myboot.app1.dao.CurriculumeVitaeRepository;
import myboot.app1.dao.PersonRepository;
import myboot.app1.model.Activity;
import myboot.app1.model.CV;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

import static myboot.app1.model.Activity.Nature.*;

@RequestMapping("/")
@Service
public class Populate {

    @Autowired
    PersonRepository PR;

    @Autowired
    ActivityRepository AR;

    @Autowired
    CurriculumeVitaeRepository CR;


    @PostConstruct
    public void init(){


        CV cv1= new CV();
        CV cv2= new CV();
        CV cv3= new CV();

        CR.save(cv1);
        CR.save(cv2);
        CR.save(cv3);


        Person p1= new Person("katia","HALLAI","katia.hallai@gmail.com"," ","4/10/1996","halkati",cv1);
        Person p2 = new Person("agueni", "farouk", "farouk@gmail.com", " ", "06/12/1999", "123",cv2);
        Person p3= new Person(" jean-luc","MASSAT","jl.massat@gmail.Com"," "," 01/01/2000","jlmassat",cv3);
        Person p4= new Person(" pierre","DUPONT","pierre.dupont@gmail.Com"," ","12/12/2000 ","pierredupont",cv1);

        PR.save(p1);
        PR.save(p2);
        PR.save(p3);
        PR.save(p4);

        Activity a1 = new Activity(2022,FORMATION, "M2 IDL","formation intéresante","https://formations.univ-amu.fr/fr/master/5SIN");
        Activity a2 = new Activity(2018,EXPERIENCEPROFESSIONNELLE, "Babysitter"," "," ");
        Activity a3=  new Activity(2021,PROJETS, "JEE/SPRING"," "," ");

        AR.save(a1);
        AR.save(a2);
        AR.save(a3);


        cv1.getActivities().add(a1);
        cv2.getActivities().add(a2);
        cv3.getActivities().add(a3);


        CR.save(cv1);
        CR.save(cv2);
        CR.save(cv3);




    }




}
