package com.rental.advertisements;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping (
            value = "login/{username}/{password}",
            method = RequestMethod.GET,
            produces = {"application/JSON"}
    )
    @ResponseBody
    String login(@PathVariable String username, @PathVariable String password) {
        /*TODO: Implement this using the database*/
        if (username.equals("example@gmail.com") && password.equals("123456")) {
            return "{\"result\" : \"success\"}";
        } else {
            return "{\"result\" : \"failed\"}";
        }
    }

    @RequestMapping (value = "signup", method = RequestMethod.POST,
            consumes = {"application/JSON"},
            produces = {"application/JSON"}
    )
    @ResponseBody
    String signup(@RequestBody String body){
        /*TODO: Implement this using the database*/
        System.out.println(body);
        return "{\"result\" : \"created\"}";
    }

    @RequestMapping (value = "", method = RequestMethod.GET)
    public String user() {
        /*TODO: Implement this*/
        return "Error 404 : User";
    }
}