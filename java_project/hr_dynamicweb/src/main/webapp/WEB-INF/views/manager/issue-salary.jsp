<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>HR Application System - Employee Monthly Salary Form</title>
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
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Employee Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="manager?viewEmployee">View Employee</a></li>
              <li><a class="dropdown-item" href="manager?addEmployee">Add Employee</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Salary Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="manager?viewSalary">View Salary</a></li>
              <li><a class="dropdown-item" href="manager?viewPayment">View Payment</a></li>
              <li><a class="dropdown-item" href="manager?issueSalary">Issue Salary</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="manager?viewLeave">Leave Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="manager?viewLoan">Loan Section</a>
          </li> 
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Others
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="manager?viewTraining">View Training</a></li>
              <li><a class="dropdown-item" href="manager?issueTraining">Issue Training</a></li>
              <li><a class="dropdown-item" href="manager?viewResignation">View Resignation</a></li>
              <li><a class="dropdown-item" href="manager?issueResignation">Issue Resignation</a></li>
            </ul>
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
      <h2 class="text-center">Employee Monthly Salary Form</h2>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form action="issueSalary" method="POST">
          <div class="row mb-3">
            <div class="col-4">
              <label for="employee_name" class="col-form-label">Employee Name</label>
            </div>
            <div class="col-5">
              <input type="text" class="form-control" id="employee_name" name="employee_name" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="base_salary" class="col-form-label">Base Salary</label>
            </div> 
            <div class="col-2">
              <input type="number" class="form-control" id="base_salary" name="base_salary" min="0" step="any" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="ot_pay" class="col-form-label">Overtime Pay</label>
            </div>
            <div class="col-2">
              <input type="number" class="form-control" id="ot_pay" name="ot_pay" min="0" step="any"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="deduction" class="col-form-label">Deduction</label>
            </div>
            <div class="col-2">
              <input type="number" class="form-control" id="deduction" name="deduction" min="0" step="any"/>
            </div> 
          </div>
          <div class="row mb-5">
            <div class="col-4">
              <label for="date_issue" class="col-form-label">Date Issue</label>
            </div>
            <div class="col-3">
              <input type="date" class="form-control" id="date_issue" name="date_issue" required/>
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