package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.SignUp;

import java.util.List;

public interface SignUpService {

    List<SignUp> getAllSignUps();

    SignUp getSignUpById(Long id);

    SignUp createSignUp(SignUp signUp);


    boolean deleteSignUp(Long id);

    SignUp updateSignUp(Long id, SignUp signUp);
}