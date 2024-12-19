<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Loan Section</title>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-information?id=${user.id}">Main</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-training">Training Section</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/v2/employee/view-leave">Leave Section</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/v2/employee/view-loan">Loan Section</a>
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
    <div class="row mb-3 mt-2">
      <h3>Loan Section</h3>
      <hr>
    </div>
    <div class="row mb-2">
	  	<div class="col">
	  	  <div class="float-end" style="margin-left: 10px;">
		      <button class="btn btn-dark" style="border-radius: 5px;" onclick="openWindow('${pageContext.request.contextPath}/v2/employee/form/applyLoan?name=${user.fullname}')">
		      Apply Loan
	      	  </button>
          </div>
	  	</div>
	  </div> 
    <table class="table table-bordered table-hover">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Reasons</th>
          <th scope="col">Amount</th>
          <th scope="col">Date</th>
          <th scope="col">Status</th>
          <th scope="col">Approver</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="loan" items="${loanList}">
          <tr class="fw-light">
            <th scope="row" class="fw-normal">${loan.id}</th>
            <td>${loan.reasons}</td>
            <td>${loan.amount}</td>
            <td>${loan.issueDate}</td>
            <td>${loan.status}</td>
            <td>${loan.approver}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  <script>
    function openWindow(url) {
      openWindow = window.open(url,'_blank','height=600,width=850,left=250,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
	  }
  </script>
</body>
</html>