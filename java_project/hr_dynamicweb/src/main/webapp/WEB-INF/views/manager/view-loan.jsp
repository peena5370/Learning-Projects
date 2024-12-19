<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Loan Section</title>
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
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
            <a class="nav-link active" href="manager?viewLoan">Loan Section</a>
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
  
  <div class="bootstrap-table bootstrap5"  style="margin-left: 5px; margin-right: 5px;">
    <div class="row mb-5 mt-2">
  	  <h3 class="text-center">Employees Loan List</h3>
    </div>
    <table id="table" data-toggle="table" data-show-columns="true" data-show-columns-toggle-all="true" data-pagination="true" data-search="true" data-search-highlight="true" data-height="620" class="table table-bordered table-hover">
      <thead class="water">
        <tr>
          <th data-field="id">ID</th>
          <th data-field="reasons">Reasons</th>
          <th data-field="loan_amount">Loan Amount</th>
          <th data-field="issued_date">Issued Date</th>
          <th data-field="status">Status</th>
          <th data-field="employee_name">Employee Name</th>
          <th data-field="approved_by">Approved By</th>
          <th data-field="action">Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="loan" items="${viewLoan}">
          <tr class="fw-light">
            <th scope="row" class="fw-normal">${loan.loan_id}</th>
            <td>${loan.reasons}</td>
            <td>${loan.loan_amount}</td>
            <td>${loan.issued_date}</td>
            <td>
            	<c:choose>
					<c:when test="${loan.loan_status == 'APPROVED'}">
					<img src="./resources/images/approved.png" alt="approved" class="status-btn"/>
					</c:when>
					<c:when test="${loan.loan_status == 'REJECTED'}">
					<img src="./resources/images/rejected.png" alt="rejected" class="status-btn"/>
					</c:when>
					<c:otherwise>
					<p>${loan.loan_status}</p>
					</c:otherwise>
				</c:choose>
            </td>
            <td>${loan.employee_name}</td>
            <td>${loan.approvedByManager}</td>
            <td>
              <button type="button" class="btn btn-outline-success btn-sm" onclick="location.href='updateLoanStatus?loan_id=${loan.loan_id}&status=Approved'">Approved</button>
                <button type="button" class="btn btn-outline-danger btn-sm" onclick="location.href='updateLoanStatus?loan_id=${loan.loan_id}&status=Rejected'">Rejected</button>
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