<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>HR Application System - Payroll Form</title>
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
    <div class="col-2">
      <nav>
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light">
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/main" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-group-solid.svg" width="16" height="16"></object>
                Employee Information
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/salarysection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-salary.svg" width="16" height="16"></object>
                Employee Salary
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/promotionsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-promote.svg" width="18" height="18"></object>
                Promote Information
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/promoteEmployee" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-add.svg" width="16" height="16"></object>
                Promote Employee
              </a>
            </li>
            <li class="nav-item">
              <a href="${pageContext.request.contextPath}/manager/addEmployee" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/user-add.svg" width="16" height="16"></object>
                Register New Employee
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueSalary" class="nav-link active" aria-current="page">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/payroll-issue.svg" width="16" height="16"></object>
                Issue Payroll
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/payrollsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/payroll-statement.svg" width="16" height="16"></object>
                Payroll Statements
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/leavesection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/leave-section.svg" width="16" height="16"></object>
                Leave Section
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/loansection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/loan-section.svg" width="16" height="16"></object>
                Loan Section
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/resignsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-information.svg" width="16" height="16"></object>
                Resignation Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueResignation" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-issue.svg" width="16" height="16"></object>
                Issue Resignation
              </a>
            </li>
            <li class="border-top my-2"></li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/trainingsection" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/training-information.svg" width="16" height="16"></object>
                Training Information
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/manager/issueTraining" class="nav-link link-dark">
                <object type="image/svg+xml" data="${pageContext.request.contextPath}/img/icons/resign-issue.svg" width="16" height="16"></object>
                Issue Training
              </a>
            </li>
          </ul>
          <hr>
          <div class="dropdown">
            <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="${pageContext.request.contextPath}/img/profile-template.png" alt="" width="32" height="32" class="rounded-circle me-2">
              <!-- <object type="image/svg+xml" data="./img/icons/manager-account.svg" width="32" height="32" class="rounded-circle me-2"></object> -->
              <strong>${user.fullname}</strong>
            </a>
            <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/manager/profile?id=${user.id}">Profile</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
            </ul>
          </div>
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
      <section class="row form-container">
        <form id="payroll-form">
          <div class="row mt-2">
            <h2>Employee Monthly Salary Form</h2><hr>
          </div>
          <div class="row mb-3">
            <div class="col-12">
              <label for="employee-name" class="col-form-label">Employee Name</label>
              <input type="text" class="form-control" id="employee-name" name="employee-name" required/>
            </div>    
          </div>
          <div class="row mb-3">
            <div class="col-12">
              <label for="manager-name" class="col-form-label">Manager Name</label>
              <input type="text" class="form-control" id="manager-name" name="manager-name" value="${user.fullname}"/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="base-salary" class="col-form-label">Base Salary</label>
              <input type="number" class="form-control" id="base-salary" name="base-salary" min="0" step="any" required/>
            </div>
            <div class="col-4">
              <label for="overtimepay" class="col-form-label">Overtime Pay</label>
              <input type="number" class="form-control" id="overtimepay" name="overtimepay" min="0" step="any" required/>
            </div>
            <div class="col-4">
              <label for="deduction" class="col-form-label">Salary Deduction</label>
              <input type="number" class="form-control" id="deduction" name="deduction" min="0" step="any" required/>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-4">
              <label for="issue-date" class="col-form-label">Issue Date</label>
              <input type="date" class="form-control" id="issue-date" name="issue-date" required/>
            </div>
          </div> 
          <div class="row mb-3">
            <div class="text-center">
              <button type="button" class="btn btn-primary btn-lg btn-width-2" onclick="submitAndRedirect('payroll-form', '${pageContext.request.contextPath}/manager/submitSalary');">Submit</button>
            </div>
          </div>     
        </form>
      </section>
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>