package com.project.Springboot.tutorial.controller;
import com.project.Springboot.tutorial.entity.SignUp;
import com.project.Springboot.tutorial.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public List<SignUp> getAllSignUps() {
        return signUpService.getAllSignUps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignUp> getSignUpById(@PathVariable("id") Long id) {
        SignUp signUp = signUpService.getSignUpById(id);
        if (signUp != null) {
            return ResponseEntity.ok(signUp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SignUp> createSignUp(@RequestBody SignUp signUp) {
        SignUp createdSignUp = signUpService.createSignUp(signUp);
        return ResponseEntity.ok(createdSignUp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignUp> updateSignUp(@PathVariable("id") Long id, @RequestBody SignUp signUp) {
        SignUp updatedSignUp = signUpService.updateSignUp(id, signUp);
        if (updatedSignUp != null) {
            return ResponseEntity.ok(updatedSignUp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("id") Long id) {
        boolean deleted = signUpService.deleteSignUp(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
