<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>HR Application System - Update Employee Information</title>
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
          <a class="nav-link" href="admin?addEmployee">Add Employee</a>
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
      <h2 class="text-center">Update Employee Information</h2>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form  action="updateInfo?user=admin&for=employee" method="POST">
          <div class="row mb-3">
            <div class="col-4">
              <label for="e_fullname" class="col-form-label">Full Name</label>
            </div>
            <div class="col-5">
              <input type="text" class="form-control" id="e_fullname" name="e_fullname"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="e_department" class="col-form-label">Department</label>
            </div>
            <div class="col-3">
              <input type="text" class="form-control" id="e_department" name="e_department"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="e_position]" class="col-form-label">Position</label>
            </div>
            <div class="col-3">
              <input type="text" class="form-control" id="e_position" name="e_position"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="e_phone" class="col-form-label">Phone Number</label>
            </div>
            <div class="col-3">
              <input type="text" class="form-control" id="e_phone" name="e_phone"/>
            </div>
          </div>
          <div class="row mb-5">
            <div class="col-4">
              <label for="e_email" class="col-form-label">Email Address</label>
            </div>
            <div class="col-5">
              <input type="email" class="form-control" id="e_email" name="e_email"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="text-center">
              <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
              <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Reset</button> 
              </div>
          </div>      
      </form>
      </div>
    </div>
  </div>

	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>