<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>HR Application System - Add New Employee Form</title>
  	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 my-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="admin?viewManager">View Manager</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="admin?addManager">Add Manager</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="admin?viewEmployee">View Employee</a>
        </li> 
        <li class="nav-item">
          <a class="nav-link active" href="admin?addEmployee">Add Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="#">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="login">Logout</a>
        </li>
      </ul>
    </div>
    <div class="btn-group float-right d-none d-lg-block">
      <img src="./resources/images/user-solid.svg" class="profile-btn opacity-3" id="btnGroupDrop1" data-bs-toggle="dropdown" aria-expanded="false">
      <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="btnGroupDrop1">
          <li><p class="dropdown-item">${sessionScope.username}</p></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item" href="#"><img src="./resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
          <li><a class="dropdown-item" href="login"><img src="./resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

  <div class="container-fluid">
  	<div class="row mb-5 mt-2">
  	  <h2 class="text-center">Add New Employee Form</h2>
  	</div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form action="addEmployee?user=admin" method="POST">
          <div class="row mb-3">
            <div class="col-6">
              <label for="fullname" class="col-form-label">Full Name</label>
              <input type="text" class="form-control" id="fullname" name="fullname" required/>
            </div>
            <div class="col-4">
              <label for="position" class="col-form-label">Position</label>
              <input type="text" class="form-control" id="position" name="position" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="password" class="col-form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" minlength="8" maxlength="20" required/>
            </div>
            <div class="form-text" id="validate-text"></div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="c_password" class="col-form-label">Confirmed Password</label>
              <input type="password" class="form-control" id="c_password" name="c_password" minlength="8" maxlength="20" required/>
            </div>
            <div class="form-text" id="match-text"></div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="department" class="col-form-label">Department</label>
              <input type="text" class="form-control" id="department" name="department" placeholder="HR, IT, Finance" required/>
            </div>
            <div class="col-4">
              <label for="salary" class="col-form-label">Base Salary</label>
              <input type="number" class="form-control" id="salary" name="salary" min="0" step="any" required/>
            </div>
          </div>
          <div class="row mb-5">
            <div class="col-4">
              <label for="phone" class="col-form-label">Phone Number</label>
              <input type="text" class="form-control" id="phone" name="phone" placeholder="012-3456789" required/>
            </div>
            <div class="col-5">
              <label for="email" class="col-form-label">Email Address</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="mail@company.com" required/>
            </div>
          </div>
          <div class="row">
            <div class="text-center">
              <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script>
    $('#password, #c_password').keyup(function(e) {
      var pass = $('#password').val();
      var confirm_pass = $('#c_password').val();
      var passRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,20})");

      if(pass=="" || !pass.match(passRegex)) {
        e.preventDefault();
        $('#validate-text').text("Password should consists of atleast 1 upper and lowercase letter, 1 symbol, 1 numeric, and length should between 8 to 20.").addClass('text-danger');
      } else if(confirm_pass===pass && pass.match(passRegex)) {
        $('#validate-text').hide();
        $('#match-text').text("Password match.").addClass('text-success');
      } else {
        e.preventDefault();
        $('#match-text').text("Password Doesn't Match!");
      }
      return true;
    }); 
  </script>
</body>
</html>