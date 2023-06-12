package com.project.FacilTren.FacilTren.UserApi.services;



import com.project.FacilTren.FacilTren.UserApi.model.UserModel;

import java.util.List;

public interface UserService {

    public UserModel saveUser(UserModel user);

    public List<UserModel> getAllUsers();

    UserModel assignProject(Long empid, Long projectid);
}
