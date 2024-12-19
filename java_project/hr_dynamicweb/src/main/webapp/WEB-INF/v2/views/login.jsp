<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
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
	<div class="container">
    <div class="row">
      <div class="col-9" style="padding: 0;">
        <img class="img-fluid bg-img" src="./resources/images/main-img.jpg" alt="main-page"/>
      </div>
      <div class="col-3 login-form-1">
        <div class="row">
          <h3 class="text-center">Login</h3>
        </div>
          <form action="user-login" method="POST">
            <div class="mb-3">
              <input type="text" class="form-control" name="username" placeholder="User Name"/>
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" name="password"/>
            </div>
            <div class="mb-3">
              <input type="submit" class="btn btn-outline-primary col-12" value="Login"/>
            </div>
            <div class="mb-3">
              <a href="#">Forget Password?</a>
            </div>
          </form>
      </div>
    </div>
  </div>

  <script src="resources/js/jquery-3.6.0.min.js"></script>
  <script src="resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>