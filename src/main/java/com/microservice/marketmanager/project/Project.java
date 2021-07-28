package com.microservice.marketmanager.project;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "projects")
@RequiredArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long projectID;
    private String projectName;
    private String location;
    private Date startingDate;
    private int estimatedDuration;

    public Project (String projectName, String location, Date startingDate, int estimatedDuration) {
        this.projectName = projectName;
        this.location = location;
        this.startingDate = startingDate;
        this.estimatedDuration = estimatedDuration;
    }
}
