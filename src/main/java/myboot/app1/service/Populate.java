package myboot.app1.service;


import myboot.app1.dao.PersonRepository;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@RequestMapping("/")
@Service
public class Populate {

    @Autowired
    PersonRepository PR;


    @PostConstruct
    public void init(){

        Person p1= new Person("katia","HALLAI","katia.hallai@gmail.com"," ","4/10/96","halkati");
        Person p2 = new Person("agueni", "farouk", "farouk@gmail.com", " ", "06/12/1999", "123");
        Person p3= new Person(" jean-luc","MASSAT","jl.massat@gmail.Com"," "," ","jlmassat");
        Person p4= new Person(" pierre","DUPONT","pierre.dupont@gmail.Com"," "," ","pierredupont");

        PR.save(p1);
        PR.save(p2);
        PR.save(p3);
        PR.save(p4);



    }




}
