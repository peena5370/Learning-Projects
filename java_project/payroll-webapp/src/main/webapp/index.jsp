<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>
	<div class="container">
    <div class="row">
      <div class="col-9" style="padding: 0;">
        <img class="img-fluid bg-img" src="${pageContext.request.contextPath}/img/main-img.jpg" alt="main-page"/>
      </div>
      <div class="col-3 login-form-1">
        <div class="row">
          <h3 class="text-center">Login</h3>
        </div>
          <form id="login-form" action="${pageContext.request.contextPath}/user-login">
            <div class="mb-3">
              <input type="text" class="form-control" id="username" name="username" placeholder="User Name" required/>
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="password" name="password" required/>
            </div>
            <div class="mb-3">
              <input type="button" id="submit-btn" class="btn btn-outline-primary col-12" value="Login"/>
            </div>
          </form>
      </div>
    </div>
  </div>
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
    $('#submit-btn').click(function(e) {
    	var form = $('#login-form');
    	var obj = form.serialize();
    	$.ajax({
    		async: false,
    		type: "POST",
    		url: form.attr('action'),
    		contentType: "application/x-www-form-urlencoded; charset=utf-8",
    		data: obj,
    		dataType: "json",
    		success: function(data) {
    			
    			switch(data.code) {
	    			case 100:
	    				alert(data.msg);
	    				break;
	    			case 103:
	    				alert(data.msg);
	    				break;
	    			case 104:
	    				alert(data.msg);
	    				break;
	    			default:
	    				window.location.href = "${pageContext.request.contextPath}" + data.httpUrl;
	    				break;
    			}
    		},
    		error: function() {
    			alert('Error logging into system, please try again.');
    		}
    	});
    });
  </script>
</body>
</html>