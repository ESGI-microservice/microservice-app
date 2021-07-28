package com.microservice.marketmanager.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> getAllProjects() {return this.projectRepository.findAll();}

    public Project projectById(Long id) {
        var project = this.projectRepository.findById(id);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return project.get();
    }

    public Project addProject (Project project) {
        var optionalProject = this.projectRepository.findById(project.getProjectID());
        if (optionalProject.isPresent()) throw new IllegalStateException("Project already existing");

        return this.projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        boolean exists = this.projectRepository.existsById(projectId);
        if (!exists) throw new IllegalStateException("Could not delete project : project does not exist");
        this.projectRepository.deleteById(projectId);
    }
}
