<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Employee Section</title>
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
          <a class="nav-link active" href="employee?profile">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="employee?training">Training</a>
        </li> 
        <li class="nav-item">
          <a class="nav-link" href="employee?salary">Salary</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="employee?leave">Leave</a>
        </li> 
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Others
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="employee?applyLeave">Applying Leave</a></li>
            <li><a class="dropdown-item" href="employee?applyLoan">Applying Loan</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="employee?profile">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="login">Logout</a>
        </li>
      </ul>
    </div>
    <div class="btn-group float-right d-none d-lg-block">
      <img src="./resources/images/user-solid.svg" class="profile-btn opacity-3" id="btnGroupDrop1" data-bs-toggle="dropdown" aria-expanded="false">
      <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="btnGroupDrop1">
          <li><p class="dropdown-item">${employee.fullname}</p></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item" href="employee?profile"><img src="./resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
          <li><a class="dropdown-item" href="login"><img src="./resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
  <div class="container-fluid">
    <div class="row mb-5 mt-2">
      <h2 class="text-center">Employee's Profile</h2>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <div class="row mb-3">
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Employee ID:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.id}</label>
          </div>
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Employee Name:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.fullname}</label>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Department:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.department}</label>
          </div>
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Position:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.position}</label>
          </div>
        </div>
        <div class="row mb-5">
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Phone Number:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.phone}</label>
          </div>
          <div class="col-6">
            <label for="employee"  class="col-form-label fw-bolder">Email:</label></br>
            <label for="employee"  class="col-form-label fw-light">${employee.email}</label>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-3"></div>
          <div class="col-6">
            <button type="button" class="btn btn-outline-secondary" onclick="openWindow('editInfo?id=${employee.id}'); return false;">Edit Information</button>
            <button type="button" class="btn btn-outline-secondary" onclick="openWindow('changePassword?id=${employee.id}'); return false;">Change Password</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script>
    function openWindow(url) {
      openWindow = window.open(url,'_blank','height=600,width=800,left=250,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
	  }
  </script>
</body>
</html>