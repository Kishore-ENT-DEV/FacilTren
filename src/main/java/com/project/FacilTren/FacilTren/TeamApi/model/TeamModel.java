package com.project.FacilTren.FacilTren.TeamApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.FacilTren.FacilTren.ProjectApi.model.ProjectModel;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="TEAM_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamID;

    @NotNull
    @Column(unique = true)
    private String teamCode;

    private String teamName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedTeams")
    private Set<ProjectModel> teams = new HashSet<>();
}
