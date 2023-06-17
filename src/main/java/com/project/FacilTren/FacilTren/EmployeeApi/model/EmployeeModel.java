package com.project.FacilTren.FacilTren.EmployeeApi.model;


import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long userID;
        @NonNull
        @Column(unique=true)
        private String employeeID;
        private String userName;
        private String emailID;
        @NonNull
        private String userType;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "USER_PROJECT",
        joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
        private Set<ProjectModel> assignedProjects = new HashSet<>();
}
