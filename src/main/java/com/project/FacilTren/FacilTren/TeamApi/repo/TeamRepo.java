package com.project.FacilTren.FacilTren.TeamApi.repo;

import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<TeamModel, Long> {
}
