<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Main Section</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
   
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/FileSaver/FileSaver.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsPDF/polyfills.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsPDF/jspdf.umd.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/html2canvas/html2canvas.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/tableExport.min.js"></script>
</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-2">
      <nav>
        <div class="flex-shrink-0 p-3 bg-white">
          <header>
            <img src="${pageContext.request.contextPath}/img/profile-template.png">
            <p>${user.fullname}</p>
            <p style="font-size: 15px;">${user.role}</p>
          </header>
          <ul class="list-unstyled ps-0">
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#department-collapse" aria-expanded="false">
              Departments
              </button>
              <div class="collapse" id="department-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/departmentsection" class="link-dark rounded">Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addDepartment" class="link-dark rounded">Add New Department</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#emplyoee-collapse" aria-expanded="false">
              Employee
              </button>
              <div class="collapse" id="emplyoee-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/employeesection" class="link-dark rounded">Employee Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addEmployee" class="link-dark rounded">Register New Employee</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#manager-collapse" aria-expanded="false">
              Manager
              </button>
              <div class="collapse" id="manager-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/main" class="link-dark rounded">Manager Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addManager" class="link-dark rounded">Register New Manager</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#system-account-collapse" aria-expanded="false">
              System Accounts
              </button>
              <div class="collapse" id="system-account-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/accountemployee" class="link-dark rounded">Employee</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/accountmanager" class="link-dark rounded">Manager</a></li>
                </ul>
              </div>
            </li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#title-collapse" aria-expanded="false">
              Title/Position
              </button>
              <div class="collapse" id="title-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/titlesection" class="link-dark rounded">Information</a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/addTitle" class="link-dark rounded">Add New Title</a></li>
                </ul>
              </div>
            </li>
            <li class="border-top my-3"></li>
            <li class="mb-1">
              <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
              Account
              </button>
              <div class="collapse" id="account-collapse">
                <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                  <li><a href="${pageContext.request.contextPath}/admin/profile?id=${user.id}" class="link-dark rounded">Profile</a></li>
                  <li><a href="${pageContext.request.contextPath}/logout" class="link-dark rounded">Sign out</a></li>
                </ul>
              </div>
            </li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="col-10">
      <div class="row">
        <div class="col" style="background-color: #adf; height: 50px; display: block; position: relative;">
          <a href="${pageContext.request.contextPath}/logout">
            <img src="${pageContext.request.contextPath}/img/log-out.svg" alt="" width="40" height="40" class="float-end mt-1">
          </a>
        </div>
      </div>
      <div class="row bootstrap-table bootstrap5 text-nowrap">
        <div>
          <h3>Company's Manager List</h3><hr>
        </div>
        <table id="table" class="table table-responsive table-borderless" 
          data-toggle="table" 
          data-show-columns="true" 
          data-show-columns-toggle-all="true" 
          data-pagination="true" 
          data-search="true" 
          data-search-highlight="true" 
          data-height="620">
          <thead>
            <tr class="border-bottom">
              <th data-field="id">ID</th>
              <th data-field="fullname">Full Name</th>
              <th data-field="role">Role</th>
              <th data-field="title">Title</th>
              <th data-field="department">Department</th>
              <th data-field="gender">Gender</th>
              <th data-field="age">Age</th>
              <th data-field="martial-status">Martial Status</th>
              <th data-field="education">Education Level</th>
              <th data-field="address">Address</th>
              <th data-field="state">State</th>
              <th data-field="country">Country</th>
              <th data-field="phone">Phone</th>
              <th data-field="email">Email</th>
              <th data-field="date-hired">Date Hired</th>
              <th data-field="date-quit">Date Resign</th>
              <th data-field="Action">Action</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="manager" items="${managerList}">
              <tr class="fw-light border-bottom">
                <th scope="row" class="fw-normal">${manager.id}</th>
                <td>${manager.fullname}</td>
                <td>${manager.role}</td>
                <td>${manager.title}</td>
                <td>${manager.department}</td>
                <td>${manager.gender}</td>
                <td>${manager.age}</td>
                <td>${manager.martialStatus}</td>
                <td>${manager.education}</td>
                <td>${manager.address}</td>
                <td>${manager.state}</td>
                <td>${manager.country}</td>
                <td>${manager.phone}</td>
                <td>${manager.email}</td>
                <td>${manager.dateHired}</td>
                <td>${manager.dateQuit}</td>
                <td>
                  <button type="button" class="btn btn-outline-info btn-sm btn-width-1" onclick="location.href='${pageContext.request.contextPath}/admin/updateManager?id=${manager.id}'">Edit</button>
                  <button type="button" class="btn btn-outline-danger btn-sm btn-width-1" onclick="deleteAlertMsg('${pageContext.request.contextPath}/admin/deleteManager?id=${manager.id}')">Delete</button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <div class="float-right">
          <div class="btn-group" role="group">
            <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary btn-sm dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="${pageContext.request.contextPath}/img/download.png" style="width: 15px; height: 15px;"/>&nbsp;&nbsp;Export
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
    </div>
  </div>
</div> 

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-export.js"></script>
</body>
</html>