package com.project.FacilTren.FacilTren.ProjectApi.service.projectImpl;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.ProjectApi.repo.ProjectRepo;
import com.project.FacilTren.FacilTren.ProjectApi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public ProjectModel createProject(ProjectModel projectModel) {
        return projectRepo.saveAndFlush(projectModel);
    }
}
