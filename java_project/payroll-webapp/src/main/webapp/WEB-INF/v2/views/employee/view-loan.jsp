<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Loan Section</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous"/>
    
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-3">
      <nav>
        <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
          <header>
            <img src="${pageContext.request.contextPath}/img/profile-template.png">
            <p>${user.fullname}</p>
          </header>
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/employee/main/${user.id}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-home.svg" width="16" height="16"></object>
                Home
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/training?name=${user.fullname}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-training-white.svg" width="16" height="16"></object>
                Training Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/leave?name=${user.fullname}" class="nav-link text-white">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-leave.svg" width="16" height="16"></object>
                Attendance/Leave
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/employee/loan?name=${user.fullname}" class="nav-link active" aria-current="page">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-loan-white.svg" width="16" height="16"></object>
                Loan Statements/Applications
              </a>
            </li>
          </ul>
          <hr>
          <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
              <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/employee-account-white.svg" width="32" height="32"></object>
              <strong>Account</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/employee/profile?id=${user.id}">Profile</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="col-9">
      <div class="row">
        <div class="col" style="background-color: #adf; height: 50px; display: block; position: relative;">
          <a href="${pageContext.request.contextPath}/logout">
            <img src="${pageContext.request.contextPath}/img/log-out.svg" alt="" width="40" height="40" class="float-end mt-1">
          </a>
        </div>
      </div>
      <section class="row">
        <div class="row">
          <h3>Loan Section</h3><hr>
        </div>
        <div class="row mb-2">
          <div class="col">
            <div class="float-end" style="margin-left: 10px;">
              <button class="btn btn-dark" style="border-radius: 5px;" onclick="openPopUpWindow('${pageContext.request.contextPath}/employee/applyLoan?name=${user.fullname}')">
              Apply Loan
              </button>
              </div>
          </div>
        </div> 
        <div class="row">
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
      </section>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>