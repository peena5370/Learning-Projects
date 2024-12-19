<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Main Page</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
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
            <a class="nav-link active" href="${pageContext.request.contextPath}/v2/employee/view-information?id=${user.id}">Main</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-training">Training Section</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-leave">Leave Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-loan">Loan Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/v2/employee/profile?id=${user.id}">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/user-logout">Logout</a>
          </li>
        </ul>
      </div>
      <div class="btn-group float-right d-none d-lg-block">
        <img src="${pageContext.request.contextPath}/resources/images/user-solid.svg" class="profile-btn opacity-3" id="btnGroupDrop1" data-bs-toggle="dropdown" aria-expanded="false">
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="btnGroupDrop1">
            <li><p class="dropdown-item">${user.fullname}</p></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/employee/profile?id=${user.id}"><img src="${pageContext.request.contextPath}/resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-logout"><img src="${pageContext.request.contextPath}/resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>
  
<div class="container form-container">
    <div class="row px-5">
      <div class="d-flex flex-row bd-highlight mb-3">
        <div class="p-2 bd-highlight">
          <img src="${pageContext.request.contextPath}/resources/images/profile-template.png" style="width: 150px; height: 200px;">
        </div>
        <div class="p-2 bd-highlight" style="display: flex; flex-direction: column;">
          <div style="margin-top: auto;">
            <h3>${user.fullname}</h3>
          </div>
        </div>  
      </div>
      <div class="row mb-2 mt-3">
      	<div class="col">
      	  <h3>Personal's Information</h3>
          <hr>
      	</div>
      </div>
      <div class="row mb-4">
        <div class="col-2">
          <label for="id" class="col-form-label fw-bolder">Employee ID:</label>
        </div>
        <div class="col-4">
          <label for="id" class="col-form-label fw-light">${user.id}</label>
        </div>
        <div class="col-2">
          <label for="fullname" class="col-form-label fw-bolder">Employee Name:</label>
        </div>
        <div class="col-4">
          <label for="fullname" class="col-form-label fw-light">${user.fullname}</label>
        </div>
      </div>
      <div class="row mb-4">
        <div class="col-2">
          <label for="gender" class="col-form-label fw-bolder">Gender:</label>
        </div>
        <div class="col-4">
          <label for="gender" class="col-form-label fw-light">${user.gender}</label>
        </div>
        <div class="col-2">
          <label for="martial-status" class="col-form-label fw-bolder">Martial Status:</label>
        </div>
        <div class="col-4">
          <label for="martial-status" class="col-form-label fw-light">${user.martialStatus}</label>
        </div>
      </div>
      <div class="row mb-5">
        <div class="col-2">
          <label for="age" class="col-form-label fw-bolder">Age:</label>
        </div>
        <div class="col-4">
          <label for="age" class="col-form-label fw-light">${user.age}</label>
        </div>
        <div class="col-2">
          <label for="education" class="col-form-label fw-bolder">Education Level:</label>
        </div>
        <div class="col-4">
          <label for="education" class="col-form-label fw-light">${user.education}</label>
        </div>
      </div>
      <div class="row mb-2">
        <div class="col">
          <h3>Location Information</h3>
          <hr>
        </div>
      </div>
      <div class="row mb-4">
        <div class="col-2">
          <label for="address" class="col-form-label fw-bolder">Home Address:</label>
        </div>
        <div class="col-4">
          <label for="address" class="col-form-label fw-light">${user.address}</label>
        </div>
        <div class="col-2">
          <label for="state"  class="col-form-label fw-bolder">State:</label>
        </div>
        <div class="col-4">
          <label for="state"  class="col-form-label fw-light">${user.state}</label>
        </div>
      </div>
      <div class="row mb-5">
        <div class="col-2">
          <label for="country"  class="col-form-label fw-bolder">Country:</label>
        </div>
        <div class="col-4">
          <label for="country"  class="col-form-label fw-light">${user.country}</label>
        </div>
      </div>
      <div class="row mb-2">
        <div class="col">
          <h3>Job Information</h3>
          <hr>
        </div>
      </div>
      <div class="row mb-4">
        <div class="col-2">
          <label for="title"  class="col-form-label fw-bolder">Job Title:</label>
        </div>
        <div class="col-4">
          <label for="title"  class="col-form-label fw-light">${user.title}</label>
        </div>
        <div class="col-2">
          <label for="department"  class="col-form-label fw-bolder">Department:</label>
        </div>
        <div class="col-4">
          <label for="department"  class="col-form-label fw-light">${user.department}</label>
        </div>
      </div>  
      <div class="row mb-4">
        <div class="col-2">
          <label for="phone"  class="col-form-label fw-bolder">Phone Number:</label>
        </div>
        <div class="col-4">
          <label for="phone"  class="col-form-label fw-light">${user.phone}</label>
        </div>
        <div class="col-2">
          <label for="email"  class="col-form-label fw-bolder">Company's Email:</label>
        </div>
        <div class="col-4">
          <label for="email"  class="col-form-label fw-light">${user.email}</label>
        </div>
      </div>  
      <div class="row mb-4">
        <div class="col-2">
          <label for="date-hired"  class="col-form-label fw-bolder">Service Start Date:</label>
        </div>
        <div class="col-4">
          <label for="date-hired"  class="col-form-label fw-light">${user.dateHired}</label>
        </div>
        <div class="col-2">
          <label for="hirer"  class="col-form-label fw-bolder">Supervisor:</label>
        </div>
        <div class="col-4">
          <label for="hirer"  class="col-form-label fw-light">${user.hirer}</label>
        </div>
      </div>  
      <div class="row mb-4">
        <div class="col-2">
          <label for="monthly-salary"  class="col-form-label fw-bolder">Monthly Salary:</label>
        </div>
        <div class="col-4">
          <label for="monthly-salary"  class="col-form-label fw-light">RM ${employeeSalary.monthlySalary}</label>
        </div>
        <div class="col-2">
          <label for="annual-salary"  class="col-form-label fw-bolder">Annual Salary:</label>
        </div>
        <div class="col-4">
          <label for="annual-salary"  class="col-form-label fw-light">RM ${employeeSalary.annualSalary}</label>
        </div>
      </div>    
    </div>
    <div class="row mb-2">
      <div class="col px-5">
        <h3>Monthly Salary Information</h3>
        <hr>
      </div>
    </div>
    <div class="row mb-3 px-5">
	    <table class="table table-bordered table-hover">
	      <thead>
	        <tr>
	          <th scope="col">ID</th>
	          <th scope="col">Basic Salary</th>
	          <th scope="col">Overtime Pay</th>
	          <th scope="col">Deduction</th>
	          <th scope="col">Total</th>
	          <th scope="col">Payment Date</th>
	          <th scope="col">Approver</th>
	        </tr>
	      </thead>
	      <tbody>
	        <c:forEach var="payroll" items="${payrollList}">
	          <tr class="fw-light">
	            <th scope="row" class="fw-normal">${payroll.id}</th>
	            <td>${payroll.baseSalary}</td>
	            <td>${payroll.overtimepay}</td>
                <td>${payroll.deduction}</td>
                <td>${payroll.total}</td>
                <td>${payroll.issueDate}</td>
                <td>${payroll.approver}</td>
	          </tr>
	        </c:forEach>
	      </tbody>
	    </table>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>