<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Utilities(Leave Section)</title>
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
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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

  <div class="bootstrap-table bootstrap5 container-bg" style="margin: 0 5px 0 5px;">
    <div class="row mb-5 mt-3">
      <h3 class="text-center">Employee Leave List</h3>
      <hr>
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
          <th data-field="reasons">Reasons</th>
          <th data-field="start-date">Start Date</th>
          <th data-field="end-date">End Date</th>
          <th data-field="type">Type</th>
          <th data-field="status">Status</th>
          <th data-field="employee-name">Employee Name</th>
          <th data-field="approver">Approved By</th>
          <th data-field="action">Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="leave" items="${leaveList}">
          <tr class="fw-light">
            <th scope="row" class="fw-normal">${leave.id}</th>
            <td>${leave.reasons}</td>
            <td>${leave.dateFrom}</td>
            <td>${leave.dateTo}</td>
            <td>${leave.type}</td>
            <td>
                <c:choose>
					<c:when test="${leave.status == 'APPROVED'}">
					<img src="${pageContext.request.contextPath}/resources/images/approved.png" alt="approved" class="status-btn"/>
					</c:when>
					<c:when test="${leave.status == 'REJECTED'}">
					<img src="${pageContext.request.contextPath}/resources/images/rejected.png" alt="rejected" class="status-btn"/>
					</c:when>
					<c:otherwise>
					<p>${leave.status}</p>
					</c:otherwise>
				</c:choose>
            </td>
            <td>${leave.employeeName}</td>
            <td>${leave.approver}</td>
            <td>
              <button type="button" class="btn btn-outline-info btn-sm" onclick="location.href='${pageContext.request.contextPath}/v2/manager/form/submit/updateEmployeeLeave?id=${leave.id}&status=APPROVED&by=${user.fullname}'">Approved</button>
              <button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/v2/manager/form/submit/updateEmployeeLeave?id=${leave.id}&status=REJECTED&by=${user.fullname}'">Rejected</button>
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
</body>
</html>