<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您已退出Itcast OA系统</title>
<link href="${pageContext.request.contextPath }/style/blue/logout.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg>
						<img id=LogoutImg
							src="${pageContext.request.contextPath }/style/blue/images/logout/logout.gif"
							border=0 /><img id=LogoutTitle
							src="${pageContext.request.contextPath }/style/blue/images/logout/logout1.gif" border=0 />
					</div>
					<div id=LogoutOperate>
						<img
							src="${pageContext.request.contextPath }/style/blue/images/logout/logout2.gif"
							border=0 /> <a href="${pageContext.request.contextPath }">重新进入系统</a> <img
							src="${pageContext.request.contextPath }/style/blue/images/logout/logout3.gif"
							border=0 /> <a href="javascript: window.close();">关闭当前窗口</a>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
