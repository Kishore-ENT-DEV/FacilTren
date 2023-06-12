package com.project.FacilTren.FacilTren.ProjectApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.FacilTren.FacilTren.UserApi.model.UserModel;
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
    private String ProjectCode;

    private String ProjectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<UserModel> projects = new HashSet<>();
}
