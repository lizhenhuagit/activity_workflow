package com.imooc.activity_workflow;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


public class Part1_Deployment extends ActivityWorkflowApplicationTests {

    @Autowired
    private RepositoryService repositoryService;

    //通过bpmn部署流程
    @Test
    public void initDeploymentBPMN(){
        String filename="BPMN/Part1_Deployment.bpmn";
        // String pngname="BPMN/Part1_Deployment.png";
        Deployment deployment=repositoryService.createDeployment()
                .addClasspathResource(filename)
                //.addClasspathResource(pngname)//图片
                .name("流程部署测试候选人task")
                .deploy();
        System.out.println(deployment.getName());
    }

    @Test
    public void getDeploymentBPMN(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition: list) {
            System.out.println(processDefinition.getVersion());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getId());
        }
    }
}
