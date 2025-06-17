<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib  uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>JSP Learning</title>
    </head>
    <body>
        <%
                out.println("SessionId: " + request.getSession().getId() + 
                        "<br/>Remote Address: " + request.getRemoteAddr());
        %>
        <br/>
        <a href="ViewUser">click for invalidate session</a>
        <br/>
        <a href="ViewUser?action=click1">click for redirect to page 1</a>
        <br/>
        <a href="ViewUser?action=click2">click for redirect to page 2</a>
        <br/>
        <a href="ViewUser?action=click3">click for redirect to no redirection page</a>
        <br/>
        <form action="ViewUser" method="POST">
            <div>
                <label>Input</label>
                <input type="text" id="input1" name="inputValue" />
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
        <br/>
        <p>first if</p>
        <%! String str = "string1"; %>
        <% if(str.equals("string1")) { %>
        <h1>first</h1>
        <% } else { %>
        <h1>second</h1>
        <% } %>
        <p>first switch</p>
        <c:set var="str" value="string1"/>
        <c:choose>
            <c:when test="${str == 'string1'}">
                <h3>jstl first</h3>
            </c:when>
            <c:when test="string1">
                <h3>jstl second</h3>
            </c:when>
            <c:otherwise>
                <h3>jstl otherwise</h3>
            </c:otherwise>
        </c:choose>
        <p>second switch</p>
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