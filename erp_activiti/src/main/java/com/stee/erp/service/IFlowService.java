package com.stee.erp.service;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.ProcessDefinition;

public interface IFlowService {
	public List<ProcessDefinition> getDefinitionList();
	public void deleteDeploymentById(String id);
	public void deploy(ZipInputStream zInputStream);
	public InputStream showPicByDeploymentId(String deploymentId);

}
