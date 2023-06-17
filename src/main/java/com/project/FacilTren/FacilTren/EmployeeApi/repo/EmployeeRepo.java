package com.project.FacilTren.FacilTren.EmployeeApi.repo;


import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {}
