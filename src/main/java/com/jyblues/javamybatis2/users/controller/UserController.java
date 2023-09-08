package com.jyblues.javamybatis2.users.controller;

import com.jyblues.javamybatis2.domain.service.UserService;
import com.jyblues.javamybatis2.repository.dto.User;
import com.jyblues.javamybatis2.users.dto.Request;
import com.jyblues.javamybatis2.users.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/v1/users")
    public List<User> user() {
        return userService.getUsers();
    }

    @GetMapping("/api/v1/user/{id}")
    public User findUserById(@PathVariable("id") String id) {
        return userService.findUserById(id);
    }

    @PostMapping("/api/v1/new.user")
    public ResponseEntity<Response.Base> createUser(@RequestBody Request.CreateUser params) {
        System.out.println(params.toString());

        try {
            int success = userService.createAnUser(params.getName(), params.getPassword(), params.getEmail(), params.getPhone());

            Response.CreateUser createdUser = new Response.CreateUser();
            createdUser.setId(success);
            createdUser.setName(params.getName());
            createdUser.setEmail(params.getEmail());
            createdUser.setPhone(params.getPhone());
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        }
        catch(DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            Response.Error error = new Response.Error();
            error.setErrorCode("-1");
            error.setErrorMessage("Exist User");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            Response.Error error = new Response.Error();
            error.setErrorCode("-1");
            error.setErrorMessage(error.getErrorMessage());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
