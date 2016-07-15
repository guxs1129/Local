<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript"
	src="${pageContext.request.contextPath }/script/jquery.js"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath }/script/menu.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/style/blue/menu.css" />
</head>
<body style="margin: 0">
	<div id="Menu">
		<ul id="MenuUl">
			<li class="level1">
				<div onClick="menuClick(this);" class="level1Style">
					<img
						src="${pageContext.request.contextPath }/style/images/MenuIcon/FUNC20057.gif"
						class="Icon" /> 审批流转
				</div>
				<ul style="display: none;" class="MenuLevel2">
					<li class="level2">
						<div class="level2Style">
							<img
								src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" />
							<a target="right" href="${pageContext.request.contextPath }/flow/list.do">审批流程管理</a>
						</div>
					</li>
					<li class="level2">
						<div class="level2Style">
							<img
								src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" />
							<a target="right" href="Flow_FormTemplate/list.html">表单模板管理</a>
						</div>
					</li>
					<li class="level2">
						<div class="level2Style">
							<img
								src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" />
							<a target="right" href="Flow_Formflow/formTemplateList.html">起草申请</a>
						</div>
					</li>
					<li class="level2">
						<div class="level2Style">
							<img
								src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" />
							<a target="right" href="Flow_Formflow/myTaskList.html"> 待我审批</a>
						</div>
					</li>
					<li class="level2">
						<div class="level2Style">
							<img
								src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" />
							<a target="right" href="Flow_FormFlow_Old/mySubmittedList.html">我的申请查询</a>
						</div>
					</li>
					<!--
		<li class="level2">
			<div class="level2Style"><img
                  src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif" /> <a  target="right" href="Flow_FormQuery/myApprovedList.html">经我审批</a> </div>
		</li>
		-->
				</ul>
			</li>

		</ul>
	</div>
</body>
</html>
