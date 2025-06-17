<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib  uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HR Application System</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
    </head>
    <body>
        <h1>view manager</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Role</th>
                    <th scope="col">Post</th>
                    <th scope="col">Dept</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${viewManager}">
                    <tr>
                        <th scope="row">
                            <c:out value="${user.id}" />
                        </th>
                        <td><c:out value="${user.fullname}" /></td>
                        <td><c:out value="${user.role}" /></td>
                        <td><c:out value="${user.position}" /></td>
                        <td><c:out value="${user.department}" /></td>
                        <td><c:out value="${user.phone}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a><a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </br>
        <p>id: <c:out value="${username}" /></p>
        </br>
        <a href="javascript:void(0);" onclick="getmoviename(click)" id="link">click</a></br>
        <a href="javascript:void(0);" onclick="getmoviename(click2)" id="link">click 2</a></br>
        <a href="ViewUser?action=click3">click 3</a></br>
        <div id="text">
            change
        </div>
        <script src="resources/js/jquery-3.6.0.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            <!-- $(function(){
  	    $('#link').click(function(){
            var this_href = $(this).attr('href');
            $.ajax({
            url: viewuser,
                    type: 'GET',
                    data: {
                    action : click
                    },
                    success: function(data) {
                    $('#text').html(data);
                    }
            });
            return false;
            });
            }); -- >
                    function getmoviename(id) {
                    var p_url = viewuser,
                            jQuery.ajax({
                            type: "GET",
                                    url: p_url,
                                    data: "action" : id,
                                    success: function(data) {
                                    $('#text').html(data);
                                    }
                            });
                    }
              </script>
</body>
</html>