package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.SignUp;
import com.project.Springboot.tutorial.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final SignUpRepository signUpRepository;

    @Autowired
    public SignUpServiceImpl(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @Override
    public List<SignUp> getAllSignUps() {
        return signUpRepository.findAll();
    }

    @Override
    public SignUp getSignUpById(Long id) {
         return signUpRepository.findById(id).orElse(null);
    }

    @Override
    public SignUp createSignUp(SignUp signUp) {
        return signUpRepository.save(signUp);
    }

    @Override
    public boolean deleteSignUp(Long id) {
        if (signUpRepository.existsById(id)) {
            signUpRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public SignUp updateSignUp(Long id, SignUp signUp) {
        SignUp existingSignUp = signUpRepository.findById(id).orElse(null);
        if (existingSignUp != null) {
            // Update the fields of existingSignUp with the values from signUp
            existingSignUp.setFirstName(signUp.getFirstName());
            existingSignUp.setLastName(signUp.getLastName());
            existingSignUp.setEmail(signUp.getEmail());
            existingSignUp.setPassword(signUp.getPassword());
            existingSignUp.setNic(signUp.getNic());
            existingSignUp.setGender(signUp.getGender());
            existingSignUp.setAddress(signUp.getAddress());
            existingSignUp.setMobileNumber(signUp.getMobileNumber());
            existingSignUp.setDateOfBirth(signUp.getDateOfBirth());

            return signUpRepository.save(existingSignUp);
        }
        return null;
    }
}


