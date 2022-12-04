package myboot.app4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class VueAppController {

    @RequestMapping(value = "/app")
    private ModelAndView hello() {
        return new ModelAndView("app");
    }


    @RequestMapping(value = "/persons")
    private ModelAndView getPersons() {
        return new ModelAndView("persons");
    }


    @RequestMapping(value = "/cvs")
    private ModelAndView getCvs() {
        return new ModelAndView("cvs");
    }

    @RequestMapping(value = "/create-person")
    private ModelAndView createPerson() {

        return new ModelAndView("create-person");
    }

    @RequestMapping(value = "/login")
    private ModelAndView logIn() {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/edit-activity")
    private ModelAndView editActivity() {

        return new ModelAndView("edit-activity");
    }

}