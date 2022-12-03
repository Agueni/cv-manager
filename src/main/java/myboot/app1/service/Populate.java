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


        Person p1= new Person("katia","HALLAI","katia.hallai@etu.univ-amu.fr","http://hallaikatia.com ","4/10/1996","halkati",cv1);
        Person p2 = new Person("farouk", "AGUENI", "farouk.agueni@etu.univ-amu.fr", "http://hallaikatia.com  ", "06/12/1999", "123",cv2);
        Person p3= new Person(" jean-luc","MASSAT","jl.massat@etu.univ-amu.fr","https://jean-luc-massat.pedaweb.univ-amu.fr/ens/arch-app/index.html "," 01/01/2000","jlmassat",cv3);
        Person p4= new Person(" pierre","DUPONT","pierre.dupont@gmail.Com","http://pierredupont.com  ","12/12/2000 ","pierredupont",cv1);

        PR.save(p1);
        PR.save(p2);
        PR.save(p3);
        PR.save(p4);


        CR.save(cv1);
        CR.save(cv2);
        CR.save(cv3);


        Activity a1 = new Activity(2022,FORMATION, "M2 IDL","Formation proposée par Aix-Marseille Université","https://formations.univ-amu.fr/fr/master/5SIN");
        Activity a2 = new Activity(2018,EXPERIENCEPROFESSIONNELLE, "Babysitter","Accompagner l'enfant aprés la sortie scolaire "," https://Nounoutop.com");
        Activity a3=  new Activity(2021,PROJETS, "JEE/SPRING"," Son objectif était la conception d'un annuaire de personnes"," https://annuaire.com");

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
