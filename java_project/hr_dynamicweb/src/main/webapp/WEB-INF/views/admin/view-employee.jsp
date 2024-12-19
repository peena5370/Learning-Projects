<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Employee List</title>
  <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-table.min.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">

  <script src="resources/js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="resources/js/FileSaver/FileSaver.min.js"></script>
  <script type="text/javascript" src="resources/js/js-xlsx/xlsx.core.min.js"></script>
  <script type="text/javascript" src="resources/js/jsPDF/polyfills.umd.min.js"></script>
  <script type="text/javascript" src="resources/js/jsPDF/jspdf.umd.min.js"></script>
  <script type="text/javascript" src="resources/js/html2canvas/html2canvas.min.js"></script>
  <script src="resources/js/tableExport.min.js"></script>
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
            <a class="nav-link active" href="admin?viewEmployee">View Employee</a>
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
  
  <div class="bootstrap-table bootstrap5" style="padding: 0 5px 0 5px;">
  	<div class="row mb-5 mt-2">	
      <h3 class="text-center">Company's Employee List</h3>
  	</div>
    <table id="table" data-toggle="table" data-show-columns="true" data-show-columns-toggle-all="true" data-pagination="true" data-search="true" data-search-highlight="true" data-height="620" class="table table-bordered table-hover">
      <thead class="water">
        <tr>
          <th data-field="id">Employee ID</th>
          <th data-field="fullname">Full Name</th>
          <th data-field="position">Position</th>
          <th data-field="department">Department</th>
          <th data-field="phone">Phone</th>
          <th data-field="email">Email</th>
          <th data-field="startdate">Starting Date</th>
          <th data-field="enddate">Resign Date</th>
          <th data-field="action">Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="employee" items="${viewEmployee}">
          <tr class="fw-light">
            <th scope="row" class="fw-normal">${employee.id}</th>
            <td>${employee.fullname}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.startdate}</td>
            <td>${employee.enddate}</td>
            <td>
              <button type="button" class="btn btn-outline-info btn-sm btn-width-1" onclick="location.href='updateInfo?user=admin&id=${employee.id}&role=employee'">Edit</button>
              <button type="button" class="btn btn-outline-danger btn-sm btn-width-1" onclick="location.href='deleteInfo?user=admin&id=${employee.id}&role=employee'">Delete</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="float-right">
      <div class="btn-group" role="group">
        <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary btn-sm dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
          <img src="./resources/images/download.png" style="width: 15px; height: 15px;"/>&nbsp;&nbsp;Export
        </button>
        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
          <li><a class="dropdown-item" onclick="$('#table').tableExport({type:'csv', escape:'false'});">CSV</a></li>
          <li><a class="dropdown-item" onclick="$('#table').tableExport({type:'excel', escape:'false'});">Excel</a></li>
          <li><a class="dropdown-item" onclick="$('#table').tableExport({type:'pdf', escape:'false'});">PDF</a></li>
          <li><a class="dropdown-item" onclick="$('#table').tableExport({type:'txt', escape:'false'});">TXT</a></li>
          <li><a class="dropdown-item" onclick="$('#table').tableExport({type:'png', escape:'false'});">PNG</a></li>
        </ul>
      </div>
    </div>
  </div>
  
  <script src="resources/js/bootstrap-table-locale-all.min.js"></script>
  <script src="resources/js/bootstrap-table-export.js"></script>
  <script src="resources/js/bootstrap.bundle.min.js"></script>
  <script src="resources/js/bootstrap-table.min.js"></script>
</body>
</html>