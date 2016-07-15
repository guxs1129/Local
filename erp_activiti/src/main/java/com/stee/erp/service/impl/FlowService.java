package com.stee.erp.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stee.erp.dao.IFlowDao;
import com.stee.erp.service.IFlowService;

@Service
@Transactional
public class FlowService implements IFlowService {

	@Autowired
	private IFlowDao flowDao;
	@Override
	public List<ProcessDefinition> getDefinitionList() {
		// TODO Auto-generated method stub
		return flowDao.getDefinitionList();
	}
	@Override
	public void deleteDeploymentById(String id) {
		// TODO Auto-generated method stub
		flowDao.deleteDeploymentById(id);
	}
	@Override
	public void deploy(ZipInputStream zInputStream) {
		// TODO Auto-generated method stub
		
		flowDao.deploy(zInputStream);
	}
	@Override
	public InputStream showPicByDeploymentId(String deploymentId) {
		return flowDao.showPicByDeploymentId(deploymentId);
	}


}
