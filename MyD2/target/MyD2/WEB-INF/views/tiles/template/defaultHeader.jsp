<%@page import="com.shakul.myd2.util.PropertiesCache"%>
<%@page import="java.util.Properties"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<a href="${pageContext.request.contextPath}/"><img class="logo" src="${pageContext.request.contextPath}/static/img/MyD2.png"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<br>
	<div class="logout-btn">
		<a href="<c:url value="/logout" />">  <span class="glyphicon glyphicon-log-out"></span> Logout</a>
	</div>

