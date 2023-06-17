package com.project.FacilTren.FacilTren.ProjectApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.FacilTren.FacilTren.TeamApi.model.TeamModel;
import com.project.FacilTren.FacilTren.EmployeeApi.model.EmployeeModel;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PROJECT_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectID;

    @NotNull
    @Column(unique = true)
    private String projectCode;

    private String projectName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PROJECT_TEAM",
            joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<TeamModel> assignedTeams = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<EmployeeModel> projects = new HashSet<>();
}
