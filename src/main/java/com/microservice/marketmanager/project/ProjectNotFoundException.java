package com.microservice.marketmanager.project;

public class ProjectNotFoundException extends RuntimeException{
        public ProjectNotFoundException() {
            super("Project not found");
        }
}
