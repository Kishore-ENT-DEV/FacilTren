package com.project.FacilTren.FacilTren.ProjectApi.service.projectImpl;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.ProjectApi.repo.ProjectRepo;
import com.project.FacilTren.FacilTren.ProjectApi.service.ProjectService;
import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;
import com.project.FacilTren.FacilTren.TeamApi.repo.TeamRepo;
import com.project.FacilTren.FacilTren.UserApi.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public ProjectModel createProject(ProjectModel projectModel) {
        return projectRepo.saveAndFlush(projectModel);
    }

    @Override
    public List<ProjectModel> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public ProjectModel assignTeams(Long projectId, Long teamId) {
        Set<TeamModel> teamSet = null;
        TeamModel teamModel = teamRepo.findById(teamId).get();
        ProjectModel projectModel = projectRepo.findById(projectId).get();

        teamSet = projectModel.getAssignedTeams();

        teamSet.add(teamModel);

        projectModel.setAssignedTeams(teamSet);

        return projectRepo.save(projectModel);
    }
}
