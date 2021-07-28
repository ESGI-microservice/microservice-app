package com.microservice.marketmanager.project;

//import com.microservice.marketmanager.kafka.Producer;
import com.microservice.marketmanager.kafka.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/projects")
public class ProjectController {

    private final ProjectService projectService;
    private Producer producer;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects () {
        List<Project> projectList = this.projectService.getAllProjects();
        return new ResponseEntity <>(projectList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Project> findProject (@PathVariable("id") Long id) {
        Project project = this.projectService.projectById(id);
        return new ResponseEntity <>(project, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Project> addProject () {//@RequestBody Project project
        Project project = new Project("oui", "non", Date.from(Instant.now()), 2);
        Project newProject = this.projectService.addProject(project);
        return new ResponseEntity <>(newProject, HttpStatus.CREATED);
    }

    @PostMapping(value = "/test")
    public void sendMessage(@RequestParam("msg") String msg) {
        System.out.println("POOOOOOOK");
        producer.publishToTopic(msg);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Project> deleteOne(@PathVariable Long id) {
        this.projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
