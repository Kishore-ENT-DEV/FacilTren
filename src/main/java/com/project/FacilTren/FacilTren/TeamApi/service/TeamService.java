package com.project.FacilTren.FacilTren.TeamApi.service;


import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;

import java.util.List;

public interface TeamService {

    public TeamModel createProject (TeamModel teamModel);

    List<TeamModel> getAllProjects();
}
