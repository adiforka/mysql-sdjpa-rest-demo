package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;

@Controller
//is the default mapping for all HTTP ops (excluding the ones explicitly specified, such as below)
@RequestMapping(path = "/demo")
public class MainController {

    private final UserRepository repository;

    @Autowired
    public MainController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/add")
    //the request will be parameterized with data of the user requested for addition into the db
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        repository.save(newUser);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {

        return repository.findAll();
    }
}
