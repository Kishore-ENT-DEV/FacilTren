package com.project.FacilTren.FacilTren.ProjectApi.repo;

import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectModel, Long> {
}
