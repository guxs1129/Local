package com.stee.erp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.stee.erp.exception.UserException;
import com.stee.erp.model.User;
import com.stee.erp.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
//	private static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private ProcessEngine processEngine;

	@RequestMapping("/login")
	public void login(User user, HttpServletRequest request, HttpServletResponse response) {
		// System.out.println(user);
		request.getSession().setAttribute("user", user);

		try {
			User resultUser = userService.findByNameAndPassword(user);
			request.getSession().setAttribute("user", resultUser);
			request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (UserException e) {//用户不存在返回登录页面
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
			try {
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			} catch (ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * activiti首次部署建表
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private Deployment deployInit() {
		if (processEngine == null) {
			throw new RuntimeException("processEngine is null");
		}
		DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
		deploymentBuilder.addClasspathResource("bpmn/vacation.bpmn");
		deploymentBuilder.addClasspathResource("bpmn/vacation.png");
		Deployment deploy = deploymentBuilder.deploy();
		return deploy;
	}
	// @RequestMapping("login")
	// public void login(User user,Model model) {
	// String msg=user.toString();
	// model.addAttribute("msg", msg);
	// }

	@RequestMapping("/logout")
	public String logout() {
		getRequest().getSession().removeAttribute("user");
		return "logout";
	}

	public HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;

	}
}
