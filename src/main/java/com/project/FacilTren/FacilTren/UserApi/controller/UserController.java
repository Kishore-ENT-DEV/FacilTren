package com.project.FacilTren.FacilTren.UserApi.controller;


import com.project.FacilTren.FacilTren.UserApi.model.UserModel;
import com.project.FacilTren.FacilTren.UserApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserModel user){
        UserModel  userresponse = userService.saveUser(user);
        return new ResponseEntity<>(userresponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUsers(){
        List<UserModel> userDetails = null;
        userDetails = userService.getAllUsers();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @PutMapping(value = "/{empid}/project/{projectid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel assignProject(@PathVariable Long empid, @PathVariable Long projectid){
        return userService.assignProject(empid,projectid);

    }
    
}
