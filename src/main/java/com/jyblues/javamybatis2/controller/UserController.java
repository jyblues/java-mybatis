package com.jyblues.javamybatis2.controller;

import com.jyblues.javamybatis2.model.ErrorCode;
import com.jyblues.javamybatis2.model.dto.Request;
import com.jyblues.javamybatis2.domain.service.UserService;
import com.jyblues.javamybatis2.repository.dto.User;
import com.jyblues.javamybatis2.model.dto.Response;
import com.jyblues.javamybatis2.util.log.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/api/v1/signup")
    public ResponseEntity<Response.Base> createUser(@RequestBody Request.User.SignUp params) {
        try {
            int success = userService.createOne(params.getName(), params.getPassword(), params.getEmail(), params.getPhone());

            Response.User.SignUp res = new Response.User.SignUp();
            res.setId(success);
            res.setName(params.getName());
            res.setEmail(params.getEmail());
            res.setPhone(params.getPhone());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(new Response.Error(ErrorCode.ALREADY_EXISTS), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            MyLogger.logError(e);
            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/v1/signin")
    public ResponseEntity<Response.Base> signIn(@RequestBody Request.User.SignIn params) {
        try {
            List<String> fields = new ArrayList<>();
            fields.add("id");
            fields.add("password");
            fields.add("name");
            fields.add("phone");
            User user = userService.getCustomOneByEmail(params.getEmail(), fields);
            if(user == null) {
                return new ResponseEntity<>(new Response.Error(ErrorCode.NOT_FOUND), HttpStatus.BAD_REQUEST);
            }

            if(!user.getPassword().equals(params.getPassword())) {
                return new ResponseEntity<>(new Response.Error(ErrorCode.INVALID_PASSWORD), HttpStatus.BAD_REQUEST);
            }

            Response.User.SignIn res = new Response.User.SignIn();
            res.setId(user.getId());
            res.setName(user.getName());
            res.setEmail(params.getEmail());
            res.setPhone(user.getPhone());
            res.setAccesToken("Not Yet");
            res.setRefreshToken("Not Yet");

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/api/v1/user/check.password")
    public ResponseEntity<Response.Base> checkPassword(@RequestBody Request.User.CheckPassword params) {
        try {
            List<String> fields = new ArrayList<>();
            fields.add("password");
            User user = userService.getCustomOneById(params.getId(), fields);
            if (user != null) {
                if (!params.getPassword().equals(user.getPassword())) {
                    return new ResponseEntity<>(new Response.Error(ErrorCode.FAILURE), HttpStatus.OK);
                }

                return new ResponseEntity<>(new Response.Error(ErrorCode.OK), HttpStatus.OK);
            }
            return new ResponseEntity<>(new Response.Error(ErrorCode.NOT_FOUND), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            MyLogger.logError(e);

            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/v1/user/modify.password")
    public ResponseEntity<Response.Base> modifyPassword(@RequestBody Request.User.ModifyPassword params) {
        try {
            List<String> fields = new ArrayList<>();
            fields.add("password");
            User user = userService.getCustomOneById(params.getId(), fields);
            if (user != null) {
                if (params.getNew_password().equals(user.getPassword())) {
                    return new ResponseEntity<>(new Response.Error(ErrorCode.SAME_VALUE), HttpStatus.BAD_REQUEST);
                }
            }
            userService.modifyPassword(params.getId(), params.getNew_password());

            return new ResponseEntity<>(new Response.Error(ErrorCode.OK), HttpStatus.OK);
        } catch (Exception e) {
            MyLogger.logError(e);
            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/v1/users")
    public List<User> users() {
        return userService.getAll();
    }

    @GetMapping("/api/v1/user/by.email")
    public ResponseEntity<Response.Base> findUserByEmail(@RequestParam String email) {
        try {
            User user = userService.findOneByEmail(email);
            if (user == null) {
                return new ResponseEntity<>(new Response.Error(ErrorCode.NOT_FOUND), HttpStatus.NOT_FOUND);
            }

            Response.User.Info res = new Response.User.Info();
            res.setId(user.getId());
            res.setEmail(user.getEmail());
            res.setName(user.getName());
            res.setPhone(user.getPhone());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            MyLogger.logError(e);
            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/v1/user/delete/{id}")
    public ResponseEntity<Response.Base> deleteOneById(@PathVariable("id") long id) {
        try {
            List<String> fields = new ArrayList<>();
            fields.add("id");
            User user = userService.getCustomOneById(id, fields);
            if (user == null) {
                return new ResponseEntity<>(new Response.Error(ErrorCode.NOT_FOUND), HttpStatus.OK);
            }

            userService.deleteOne(id);

            return new ResponseEntity<>(new Response.Error(ErrorCode.OK), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response.Error(ErrorCode.UNKNOWN), HttpStatus.BAD_REQUEST);
        }
    }
}
