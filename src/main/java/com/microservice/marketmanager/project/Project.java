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
    private String project_name;
    private String location;
    private Date starting_date;
    private int estimated_duration;

    public Project (String projectName, String location, Date startingDate, int estimatedDuration) {
        this.project_name = projectName;
        this.location = location;
        this.starting_date = startingDate;
        this.estimated_duration = estimatedDuration;
    }
}
