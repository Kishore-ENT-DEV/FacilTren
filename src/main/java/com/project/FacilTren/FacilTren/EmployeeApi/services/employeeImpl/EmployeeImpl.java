package com.project.FacilTren.FacilTren.EmployeeApi.services.employeeImpl;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.ProjectApi.repo.ProjectRepo;
import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;
import com.project.FacilTren.FacilTren.EmployeeApi.repo.EmployeeRepo;
import com.project.FacilTren.FacilTren.EmployeeApi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public EmployeeModel saveUser(EmployeeModel user) {
        return employeeRepo.save(user);
    }

    @Override
    public List<EmployeeModel> getAllUsers() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeModel assignProject(Long empid, Long projectid) {
        Set<ProjectModel> projectSet = null;
        EmployeeModel employeeModel = employeeRepo.findById(empid).get();
        ProjectModel projectModel = projectRepo.findById(projectid).get();

        projectSet = employeeModel.getAssignedProjects();

        projectSet.add(projectModel);

        employeeModel.setAssignedProjects(projectSet);

        return employeeRepo.save(employeeModel);

    }

}
