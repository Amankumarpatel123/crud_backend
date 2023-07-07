package com.project.Springboot.tutorial.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController   // Rest Controller add the class to spring so when the, it run it recognize the class, int return Respoinsebody
public class HelloController {


    @GetMapping("/")    //("/") is used to give endpoint similarly , post, delete can be used
    public String helloworld(){
        return "Welcome to springboot!";

    }
}
