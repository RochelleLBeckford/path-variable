package com.rochelle.pathdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // signifies that this is now the controller for my app 
// app now knows to use this as a controller

//* Note -> if just go to localhost:8080 wiill get the whitelabel error page -> since there is no controller set for this
// -> spring will check static files for something
// -> if go to static and make plain ol html it will show instead of the error page
// -> can add regular tags from html -> even a link tag to act as the links to all the routes we created
// -> it will look alot cleanerimport org.springframework.web.bind.annotation.RestController;
@RequestMapping("/test")
public class HomeController {
    @RequestMapping("")
    public String index () {
        return "<h3>Sorry, but after 8080 in the browser you will have to type \"/test/an id number to see what will display on the page =).\"</h3>";
    }
    // once setup as rest controller now to setup routes -> tell my app what to do when it hits a certain route 
    // route -> when see this route do this 
    // when see this route run this function
                        // whatever call var in path it has to be the same 
    @RequestMapping("/{id}")
    // method fire once route is hit
    // can have as many path variables as we want -> goes in param
                                // var has to be the same as what the path is called
    public String test(@PathVariable("id") String id) {
        System.out.println(id);
        // return a string
        // return "a string";

        // put the id into this "a string " is "
        // return "The answer is: %s", id;

        //? if the string is even i want to print out 1 message and if it is even I want to print out a different message
        // String so have to type cast into an Integer
        if(Integer.parseInt(id) % 2 == 0) {
            return "Rochelle is excited for Hogwarts Legacy = )!!!";
        } else {
            return String.format("The answer is: %s",id);
        }
        // now go in browser and type in /test/2 and the return value will show -> test w/ other id numbers
    }
}
