package com.microservice.marketmanager.workflow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Workflow {

    public enum WORKFLOWS{
        requestTradesman,
        matchTradesman,
        createProject
    }

    @Id
    private Long workflowID;
    private WORKFLOWS workflow_v;
}
