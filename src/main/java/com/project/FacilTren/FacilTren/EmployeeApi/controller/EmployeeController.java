package com.project.FacilTren.FacilTren.EmployeeApi.controller;


import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;
import com.project.FacilTren.FacilTren.EmployeeApi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody EmployeeModel user){
        EmployeeModel userresponse = employeeService.saveUser(user);
        return new ResponseEntity<>(userresponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeModel> getUsers(){
        List<EmployeeModel> userDetails = null;
        userDetails = employeeService.getAllUsers();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @PutMapping(value = "/{empid}/project/{projectid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel assignProject(@PathVariable Long empid, @PathVariable Long projectid){
        return employeeService.assignProject(empid,projectid);

    }
    
}
