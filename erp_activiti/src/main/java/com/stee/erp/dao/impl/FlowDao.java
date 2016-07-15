package com.stee.erp.dao.impl;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stee.erp.dao.IFlowDao;

@Repository
public class FlowDao implements IFlowDao {

	@Autowired
	private ProcessEngine processEngine;
	private static Logger logger=LogManager.getLogger(FlowDao.class);

	@Override
	public List<ProcessDefinition> getDefinitionList() {
		// TODO Auto-generated method stub
		ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
		List<ProcessDefinition> list = query.list();
		for (ProcessDefinition processDefinition : list) {
			System.out.println(processDefinition.getId()+processDefinition.getName());
		}
		return list;
	}

	/**
	 * 删除流程定义
	 * @parm id deploymentId部署id
	 */
	@Override
	public void deleteDeploymentById(String id) {
		// TODO Auto-generated method stub
		DeploymentQuery query = processEngine.getRepositoryService().createDeploymentQuery();
		query.deploymentId(id);
		Deployment deployment=query.singleResult();
		if (deployment!=null) {
			processEngine.getRepositoryService().deleteDeployment(deployment.getId(), true);
			logger.debug("==========>delete success");
		}
	}

	@Override
	public void deploy(ZipInputStream zInputStream) {
		// TODO Auto-generated method stub
		DeploymentBuilder builder = processEngine.getRepositoryService().createDeployment();
		builder.addZipInputStream(zInputStream);
		builder.deploy();
	}

	@Override
	public InputStream showPicByDeploymentId(String deploymentId) {
		return processEngine.getRepositoryService().getProcessDiagram(deploymentId);
	}

}
