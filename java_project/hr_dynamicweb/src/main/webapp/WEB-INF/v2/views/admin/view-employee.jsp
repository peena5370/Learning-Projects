<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Employee Section</title>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-manager">Main</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/v2/admin/view-employee">Employee Section</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Account Section
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/view-account-employee">Employee Account</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/view-account-manager">Manager Account</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-title">Title Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/admin/view-department">Department Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link d-lg-none d-xl-none d-xxl-none" href="${pageContext.request.contextPath}/v2/admin/profile?id=${user.id}">Profile</a>
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
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/v2/admin/profile?id=${user.id}"><img src="${pageContext.request.contextPath}/resources/images/info.svg" class="opacity-3">&nbsp;&nbsp;Profile</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user-logout"><img src="${pageContext.request.contextPath}/resources/images/log-out.svg" class="opacity-3">&nbsp;&nbsp;Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="bootstrap-table bootstrap5 container-bg" style="margin: 0 5px 0 5px;">
    <div class="row mb-5 mt-3">
      <h3 class="text-center">Company's Employee List</h3>
      <hr>
    </div>
    <div class="float-left" style="margin-left: 10px;">
      <button class="btn btn-primary" style="border-radius: 20px;"onclick="location.href='${pageContext.request.contextPath}/v2/admin/form/addEmployee'">
      <i class="fa fa-plus"></i> Add New
      </button>
    </div>
    <table id="table" class="table table-responsive table-bordered table-hover" 
    data-toggle="table" 
    data-show-columns="true" 
    data-show-columns-toggle-all="true" 
    data-pagination="true" 
    data-search="true" 
    data-search-highlight="true" 
    data-height="620">
      <thead class="sky-blue">
        <tr>
          <th data-field="id">ID</th>
          <th data-field="fullname">Full Name</th>
          <th data-field="gender">Gender</th>
          <th data-field="age">Age</th>
          <th data-field="martial-status">Martial Status</th>
          <th data-field="education">Education Level</th>
          <th data-field="title">Title</th>
          <th data-field="department">Department</th>
          <th data-field="address">Address</th>
          <th data-field="state">State</th>
          <th data-field="country">Country</th>
          <th data-field="phone">Phone</th>
          <th data-field="email">Email</th>
          <th data-field="hirer">Hired By</th>
          <th data-field="date-hired">Date Hired</th>
          <th data-field="date-quit">Date Resign</th>
          <th data-field="Action">Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="employee" items="${employeeList}">
          <tr class="fw-light">
            <th scope="row" class="fw-normal">${employee.id}</th>
            <td>${employee.fullname}</td>
            <td>${employee.gender}</td>
            <td>${employee.age}</td>
            <td>${employee.martialStatus}</td>
            <td>${employee.education}</td>
            <td>${employee.title}</td>
            <td>${employee.department}</td>
            <td>${employee.address}</td>
            <td>${employee.state}</td>
            <td>${employee.country}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.hirer}</td>
            <td>${employee.dateHired}</td>
            <td>${employee.dateQuit}</td>
            <td>
              <button type="button" class="btn btn-outline-info btn-sm btn-width-1" onclick="location.href='${pageContext.request.contextPath}/v2/admin/form/updateEmployee?id=${employee.id}'">Edit</button>
              <button type="button" class="btn btn-outline-danger btn-sm btn-width-1" onclick="deleteConfirm('${pageContext.request.contextPath}/v2/admin/form/submit/deleteEmployee?id=${employee.id}')">Delete</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="float-right">
      <div class="btn-group" role="group">
        <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary btn-sm dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
          <img src="${pageContext.request.contextPath}/resources/images/download.png" style="width: 15px; height: 15px;"/>&nbsp;&nbsp;Export
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

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-locale-all.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table-export.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-table.min.js"></script>
  <script>
    function deleteConfirm(url) {
        if (confirm("Are you really sure?")) {
        	location.href=url;
        } else {
            return false;
        }
    };
  </script>
</body>
</html>