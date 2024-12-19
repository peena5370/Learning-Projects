<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Human Resource Payroll Application System</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>

  <script src="${pageContext.request.contextPath}/js/main.js"></script>
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
      <form id="login-form">
        <div class="mb-3">
          <input type="text" class="form-control" id="username" name="username" placeholder="User Name" required/>
        </div>
        <div class="mb-3">
          <input type="password" class="form-control" id="password" name="password" required/>
        </div>
        <div class="mb-3">
          <input type="button" class="btn btn-outline-primary col-12" value="Login" onclick="loginValidate('login-form', '${pageContext.request.contextPath}/user-login');"/>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>