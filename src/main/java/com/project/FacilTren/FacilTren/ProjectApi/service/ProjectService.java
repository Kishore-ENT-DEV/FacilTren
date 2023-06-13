package com.project.FacilTren.FacilTren.ProjectApi.service;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;

import java.util.List;

public interface ProjectService {

    public ProjectModel createProject (ProjectModel projectModel);

    List<ProjectModel> getAllProjects();
}
