package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<String> findUserById(@PathVariable("id") int id) {

        if (id > 0 && id < 100) {
            return ResponseEntity.ok("You have entered valid ID");
        } else {
            throw new UserIdException("You have entered invalid ID");
        }
    }

    @GetMapping("/findUserByUserName/{username}")
    public ResponseEntity<String> findUserByUserName(@PathVariable("username") String username) {

        if (username.length() > 3 && username.length() < 15) {
            return ResponseEntity.ok("You have entered valid USERNAME");
        } else {
            throw new UserNameException("You have entered invalid USERNAME");
        }
    }

    @GetMapping("/findUserByCPF/{cpf}")
    public ResponseEntity<String> findUserByCPF(@PathVariable("cpf") String cpf) {

        if (cpf.length() > 3 && cpf.length() < 15) {
            return ResponseEntity.ok("You have entered valid CPF");
        } else {
            throw new CPFException("You have entered invalid CPF");
        }
    }
}
