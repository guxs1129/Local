package com.stee.erp.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Field;
import com.stee.erp.service.IFlowService;

@Controller
@RequestMapping("/flow")
public class FlowController {

	@Autowired
	private IFlowService flowService;

	/**
	 * 获取流程定义列表
	 * @return 流程列表页面
	 */
	@RequestMapping("/list")
	public ModelAndView list() {
		List<ProcessDefinition> list=flowService.getDefinitionList();
		Map<String, ProcessDefinition> map=new HashMap<String, ProcessDefinition>();
		for (ProcessDefinition processDefinition : list) {
			map.put(processDefinition.getKey(), processDefinition);
		}
		ModelAndView listView=new ModelAndView("/flow/definition/list");
		listView.getModel().put("list", map.values());
		return listView;
	}
	
	@RequestMapping("/test")
	public void testAjax(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getRequestURI());
		System.out.println(new Date()+"--------"+request.getParameter("param"));
		try {
			response.setStatus(200);
			response.setContentType("text/plain");
			response.getWriter().write("this is reply from test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除流程定义
	 * @param id
	 * @return 返回流程列表页面
	 */
	@RequestMapping("/deleteFlow")
	public ModelAndView deleteFlow(@RequestParam String deploymentId) {
		flowService.deleteDeploymentById(deploymentId);
		return list();
	}
	
	@RequestMapping("/addDeployment")
	public ModelAndView AddProcess(@RequestParam("resource") MultipartFile multipartFile) {
		ZipInputStream inputStream=null;
		try {
			inputStream = new ZipInputStream(multipartFile.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flowService.deploy(inputStream);
		return list();
	}
	
	@RequestMapping("/showPic")
	public void showPic(@RequestParam("deploymentId") String deploymentId,HttpServletResponse response) {
		System.out.println(deploymentId);
		InputStream inputStream=flowService.showPicByDeploymentId(deploymentId);
		response.setContentType("image/png");
		byte[] buf=new byte[1024];
		int len=0;
		try {
			OutputStream outputStream=response.getOutputStream();
			while ((len=inputStream.read(buf))!=-1) {
				outputStream.write(buf,0,len);
			}
			outputStream.close();
			inputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
