package com.project.FacilTren.FacilTren.TeamApi.service.teamImpl;

import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;
import com.project.FacilTren.FacilTren.TeamApi.repo.TeamRepo;
import com.project.FacilTren.FacilTren.TeamApi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public TeamModel createProject(TeamModel teamModel) {
        return teamRepo.saveAndFlush(teamModel);
    }

    @Override
    public List<TeamModel> getAllProjects() {
        return teamRepo.findAll();
    }
}
