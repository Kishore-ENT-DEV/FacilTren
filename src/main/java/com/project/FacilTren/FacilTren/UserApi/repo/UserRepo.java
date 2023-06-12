package com.project.FacilTren.FacilTren.UserApi.repo;


import com.project.FacilTren.FacilTren.UserApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {}
