<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Update Employee Information Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-table.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/FileSaver/FileSaver.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsPDF/polyfills.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsPDF/jspdf.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html2canvas/html2canvas.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/tableExport.min.js"></script>
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
            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Employee Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-employee">Employee List</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-promotion">Employee Promotion</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Salary Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-salary">Employee Salary</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-payroll">Payroll Statements</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Utilities
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-leave">Leave Section</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-loan">Loan Section</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-resign">Resignation Section</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/view-training">Training Section</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/v2/manager/profile?id=${user.id}">Profile</a>
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
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/manager/profile?id=${user.id}"><img src="${pageContext.request.contextPath}/resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-logout"><img src="${pageContext.request.contextPath}/resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>

<div class="container form-container">
    <div class="row px-5 mt-5">
      <form action="${pageContext.request.contextPath}/v2/manager/form/submit/submitUpdateEmployee" method="POST">
        <div class="row mb-3">
          <h4>Update Employee Information Form</h4>
          <hr>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label for="id" class="col-form-label">Employee ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${updateEmployee.id}" readonly/>
          </div>
          <div class="col-6">
            <label for="fullname" class="col-form-label">Full Name</label>
            <input type="text" class="form-control" id="fullname" name="fullname" value="${updateEmployee.fullname}" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-4">
              <label for="gender" class="col-form-label">Gender</label>
              <input type="text" class="form-control" id="gender" name="gender" value="${updateEmployee.gender}" required/>
          </div>
          <div class="col-2">
            <label for="age" class="col-form-label">Age</label>
            <input type="number" class="form-control" id="age" name="age" value="${updateEmployee.age}" required/>
          </div>
          <div class="col-2">
            <label for="martial-status" class="col-form-label">Martial Status</label>
            <input type="text" class="form-control" id="martial-status" name="martial-status" value="${updateEmployee.martialStatus}" required/>
          </div>
          <div class="col-4">
            <label for="education" class="col-form-label">Education Level</label>
            <input type="text" class="form-control" id="education" name="education" value="${updateEmployee.education}" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label for="address" class="col-form-label">Home Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${updateEmployee.address}" required/>
          </div>
          <div class="col-3">
            <label for="state" class="col-form-label">State</label>
            <input type="text" class="form-control" id="state" name="state" value="${updateEmployee.state}" required/>
          </div>
          <div class="col-3">
            <label for="country" class="col-form-label">Country</label>
            <input type="text" class="form-control" id="country" name="country" value="${updateEmployee.country}" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-4">
            <label for="phone" class="col-form-label">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${updateEmployee.phone}" required/>
          </div>
          <div class="col-4">
            <label for="email" class="col-form-label">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${updateEmployee.phone}" required/>
          </div>
        </div>
        <div class="row mb-3">
          <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg btn-width-2">Submit</button> 
            <button type="reset" class="btn btn-outline-secondary btn-lg btn-width-2">Clear</button> 
          </div>
        </div>          
      </form>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-locale-all.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-export.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
</body>
</html>