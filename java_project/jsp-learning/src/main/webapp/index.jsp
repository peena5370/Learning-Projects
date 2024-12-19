<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="TUF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("test" + request.getSession() + "\n" + request.getRemoteAddr());
	%>
	<a href="viewuser">click</a>
	</br>
	<form action="viewuser" method="POST">
		<div>
	      <label>Input</label>
	      <input type="text" id="text" name="text"/>
	    </div>
	</form>
	<%! String str = "string"; %>
	<% if(str.equals("string1")) { %>
		<h1>first</h1>
	<% } else { %>
		<h1>second</h1>
	<% } %>
	<c:set var="str" value="string"/>
	<c:choose>
		<c:when test="${str == 'string'}">
		<h3>jstl first</h3>
		</c:when>
		<c:when test="string1">
		<h3>jstl second</h3>
		</c:when>
		<c:otherwise>
		<h3>jstl otherwise</h3>
		</c:otherwise>
	</c:choose>
	<c:choose>
					<c:when test="${leave.status == 'Approved'}">
					<h3>jstl first</h3>
					</c:when>
					<c:when test="${leave.status == 'Rejected'}">
					<h3>jstl second</h3>
					</c:when>
					<c:otherwise>
					<h3>jstl otherwise</h3>
					</c:otherwise>
				</c:choose>
</body>
</html>