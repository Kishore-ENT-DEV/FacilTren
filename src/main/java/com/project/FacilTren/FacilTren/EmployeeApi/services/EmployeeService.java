package com.project.FacilTren.FacilTren.EmployeeApi.services;



import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    public EmployeeModel saveUser(EmployeeModel user);

    public List<EmployeeModel> getAllUsers();

    EmployeeModel assignProject(Long empid, Long projectid);
}
