<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <p>session: <% out.println(request.getSession().getId()); %>
            </br>
            for test 1
        </p>
    </body>
</html>