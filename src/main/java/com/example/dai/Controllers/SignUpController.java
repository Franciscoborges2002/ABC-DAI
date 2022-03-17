package com.example.dai.Controllers;

import com.example.dai.Data.SignUpForm;
import com.example.dai.Services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/signup")
public class SignUpController {
    private final SignUpService signUpServicen;

    @Autowired
    public SignUpController(SignUpService signUpServicen) {
        this.signUpServicen = signUpServicen;
    }

    @PostMapping
    public String signUp(@RequestBody SignUpForm signUpForm){
        return signUpServicen.signUp(signUpForm);
    }
}
