package com.microservice.marketmanager.workflow;

import com.microservice.marketmanager.workflow.Workflow;

public interface IWorkflow {
    public boolean toRun(Workflow workflowName);
    public void runWorkflow(Workflow workflow);
}
