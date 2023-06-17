package com.project.FacilTren.FacilTren.ProjectApi.controller;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.ProjectApi.service.ProjectService;
import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProject(@RequestBody ProjectModel projectModel){
        ProjectModel projectResponse = projectService.createProject(projectModel);
        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeModel> getUsers(){
        List<ProjectModel> projectModels = null;
        projectModels = projectService.getAllProjects();
        return new ResponseEntity(projectModels, HttpStatus.OK);
    }

    @PutMapping(value = "/{projectId}/Teams/{teamId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectModel assignProject(@PathVariable Long projectId, @PathVariable Long teamId){
        return projectService.assignTeams(projectId,teamId);

    }
}
