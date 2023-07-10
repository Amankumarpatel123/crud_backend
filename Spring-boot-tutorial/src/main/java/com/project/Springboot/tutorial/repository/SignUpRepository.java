package com.project.Springboot.tutorial.repository;

import com.project.Springboot.tutorial.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Long> {

}
