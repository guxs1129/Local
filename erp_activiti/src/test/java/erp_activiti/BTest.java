package erp_activiti;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.stee.erp.service.IFlowService;
import com.stee.erp.service.impl.FlowService;
import com.stee.erp.util.DBUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-servlet.xml","classpath:context-dataSource.xml","classpath:context-activiti.xml"})
@WebAppConfiguration
public class BTest {

	@Autowired
	private IFlowService flowService;
	

	@Test
	public void testList() throws Exception {
		List<ProcessDefinition> list=flowService.getDefinitionList();
		for (ProcessDefinition processDefinition : list) {
			System.out.println(processDefinition.getId()+"---"+processDefinition.getName());
		}
	}

}
