package com.rental.advertisements;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("user")
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    @RequestMapping (
            value = "login/{username}/{upassword}",
            method = RequestMethod.GET,
            produces = {"application/JSON"}
    )
    @ResponseBody
    String login(@PathVariable String username, @PathVariable String upassword) {
        List<User> list = this.repository.findByEmailAndUpassword(username, upassword);
        if (list.size() > 0) {
            return "{\"result\" : \"success\"}";
        }else{
            return "{\"result\" : \"failed\"}";
        }
    }


    @RequestMapping (value = "signup", method = RequestMethod.POST,
            consumes = {"application/JSON"},
            produces = {"application/JSON"}
    )
    @ResponseBody
    String signup(@RequestBody User newUser){
        this.repository.save(newUser);
        return "{\"result\" : \"created\"}";
    }

    @RequestMapping (value = "", method = RequestMethod.GET)
    public String user() {
        /*TODO: Implement this*/
        return "Error 404 : User";
    }
}