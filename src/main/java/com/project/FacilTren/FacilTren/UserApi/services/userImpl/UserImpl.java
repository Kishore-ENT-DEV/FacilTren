package com.project.FacilTren.FacilTren.UserApi.services.userImpl;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.project.FacilTren.FacilTren.ProjectApi.repo.ProjectRepo;
import com.project.FacilTren.FacilTren.UserApi.model.UserModel;
import com.project.FacilTren.FacilTren.UserApi.repo.UserRepo;
import com.project.FacilTren.FacilTren.UserApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserModel assignProject(Long empid, Long projectid) {
        Set<ProjectModel> projectSet = null;
        UserModel userModel = userRepo.findById(empid).get();
        ProjectModel projectModel = projectRepo.findById(projectid).get();

        projectSet = userModel.getAssignedProjects();

        projectSet.add(projectModel);

        userModel.setAssignedProjects(projectSet);

        return userRepo.save(userModel);

    }

}
