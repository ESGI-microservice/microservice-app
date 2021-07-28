package com.microservice.marketmanager;

import com.microservice.marketmanager.project.Project;
import com.microservice.marketmanager.project.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectImplTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    @Transactional("productTransactionManager")
    public void projectCreationCheck () throws ParseException {
        Project project = new Project();
        project.setProjectName("Sink leak");
        project.setLocation("13 baker street");
        project.setStartingDate(DateFormat.getInstance().parse("22/06/2022"));
        project.setEstimatedDuration(2);
        project = projectRepository.save(project);

        assertNotNull(projectRepository.findByProjectID(project.getProjectID()));
    }
}
