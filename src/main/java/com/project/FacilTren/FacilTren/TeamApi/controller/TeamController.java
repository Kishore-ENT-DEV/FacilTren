package com.project.FacilTren.FacilTren.TeamApi.controller;


import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;
import com.project.FacilTren.FacilTren.TeamApi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProject(@RequestBody TeamModel teamModel){
        TeamModel teamResponse = teamService.createProject(teamModel);
        return new ResponseEntity<>(teamResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamModel> getUsers(){
        List<TeamModel> projectModels = null;
        projectModels = teamService.getAllProjects();
        return new ResponseEntity(projectModels, HttpStatus.OK);
    }
}
