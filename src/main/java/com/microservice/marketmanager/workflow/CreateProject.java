package com.microservice.marketmanager.workflow;

public class CreateProject implements IWorkflow {

    public boolean toRun(Workflow workflowName) {
        return Workflow.WORKFLOWS.createProject.equals(workflowName.getWorkflow_v());
    }

    public void runWorkflow(Workflow workflow) {

    }
}